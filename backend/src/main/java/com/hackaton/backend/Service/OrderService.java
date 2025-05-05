package com.hackaton.backend.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Listing;
import com.hackaton.backend.Entity.Order;
import com.hackaton.backend.Entity.PlatformUser;
import com.hackaton.backend.Repository.ListingRepository;
import com.hackaton.backend.Repository.OrderRepository;
import com.hackaton.backend.Repository.PlatformRepository;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final ListingRepository listingRepository;
    private final PlatformRepository userRepo;

    public OrderService(OrderRepository repository, ListingRepository listingRepository, PlatformRepository userRepo) {
        this.repository = repository;
        this.listingRepository = listingRepository;
        this.userRepo = userRepo;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return repository.findById(id);
    }

    public Order save(Order order) {
        List<Listing> listings = order.getListing();

        if (listings == null || listings.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one listing.");
        }

        PlatformUser buyer = userRepo.findById(order.getBuyer().getId())
                .orElseThrow(() -> new RuntimeException("Buyer wasn't found"));

        // Extraer los IDs de los listings
        List<Long> listingIds = listings.stream()
                .map(Listing::getId)
                .collect(Collectors.toList());

        // Buscar todos los listings por sus IDs en una sola consulta
        List<Listing> completeListings = listingRepository.findAllById(listingIds);

        // Verificar si se encontraron todos los listings
        if (completeListings.size() != listingIds.size()) {
            List<Long> foundIds = completeListings.stream()
                    .map(Listing::getId)
                    .collect(Collectors.toList());
            listingIds.removeAll(foundIds); // IDs no encontrados
            throw new IllegalArgumentException("Could not find all listings with IDs: " + listingIds);
        }

        // Calcular el total a partir de la lista completa
        double total = completeListings.stream()
                .mapToDouble(Listing::getPriceUsd)
                .sum();

        order.setTotalAmount(total);
        order.setListing(completeListings);
        order.setBuyer(buyer);
        return repository.save(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Order> getByBuyer(Long buyerId) {
        return repository.findByBuyer_Id(buyerId);
    }

    public List<Order> getByListing(Long listingId) {
        return repository.findByListing_Id(listingId);
    }

    public void PayMockup(Long id) {
        Order existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment not found with id: " + id));
        existing.setStatus("Pagado");
    }

}
