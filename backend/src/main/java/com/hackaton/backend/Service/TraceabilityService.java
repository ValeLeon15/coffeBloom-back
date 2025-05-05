package com.hackaton.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Product;
import com.hackaton.backend.Entity.Traceability;
import com.hackaton.backend.Repository.ProductRepository;
import com.hackaton.backend.Repository.TraceabilityRepository;

@Service
public class TraceabilityService {
    private final TraceabilityRepository repo;
    private final ProductRepository productrepo;

    public TraceabilityService(TraceabilityRepository repo, ProductRepository productrepo) {
        this.repo = repo;
        this.productrepo=productrepo;
    }

    public List<Traceability> getAll() {
        return repo.findAll();
    }

    public Optional<Traceability> getById(Long id) {
        return repo.findById(id);
    }

    public List<Traceability> getByProduct(Long productId) {
        return repo.findByProduct_Id(productId);
    }

    public Traceability save(Traceability record) {

        Product product= productrepo.findById(record.getProduct().getId())
        .orElseThrow(() -> new RuntimeException("Product wasn't found"));

        record.setProduct(product);

        return repo.save(record);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

