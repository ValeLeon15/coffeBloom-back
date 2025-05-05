package com.hackaton.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Listing;
import com.hackaton.backend.Entity.PlatformUser;
import com.hackaton.backend.Entity.Product;
import com.hackaton.backend.Repository.ListingRepository;
import com.hackaton.backend.Repository.PlatformRepository;
import com.hackaton.backend.Repository.ProductRepository;

@Service
public class ListingService {
    private final ListingRepository repo;
    private final ProductRepository productrepo;
    private final PlatformRepository userrepo;

    public ListingService(ListingRepository repo, ProductRepository productrepo, PlatformRepository userrepo) {
        this.repo = repo;
        this.productrepo= productrepo;
        this.userrepo=userrepo;
    }

    public List<Listing> getAll() {
        return repo.findAll();
    }

    public Optional<Listing> getById(Long id) {
        return repo.findById(id);
    }

    public Listing save(Listing listing) {
        Product product = productrepo.findById(listing.getProduct().getId())
        .orElseThrow(() -> new RuntimeException("Product not found"));

        PlatformUser user = userrepo.findById(listing.getUser().getId())
        .orElseThrow(() -> new RuntimeException ("User not found"));

        listing.setUser(user);
        listing.setProduct(product);

        return repo.save(listing);
    }

    public List<Listing> getByUser(Long userId) {
        return repo.findByUser_Id(userId);
    }

    public List<Listing> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
