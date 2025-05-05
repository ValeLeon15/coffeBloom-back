package com.hackaton.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Certification;
import com.hackaton.backend.Entity.Producer;
import com.hackaton.backend.Entity.Product;
import com.hackaton.backend.Repository.CertificationRepository;
import com.hackaton.backend.Repository.ProducerRepository;
import com.hackaton.backend.Repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repo;
    private final ProducerRepository producerRepository;
    private final CertificationRepository certificationRepository;

    public ProductService(ProductRepository repo, ProducerRepository producerRepository, CertificationRepository certificationRepository) {
        this.repo = repo;
        this.producerRepository=producerRepository;
        this.certificationRepository=certificationRepository;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Optional<Product> getById(Long id) {
        return repo.findById(id);
    }

    public Product save(Product product) {
        
        Producer producer = producerRepository.findById(product.getProducer().getId())
                .orElseThrow(() -> new RuntimeException("Producer not found"));

        Certification certification = certificationRepository.findById(product.getCertification().getId())
                .orElseThrow(() -> new RuntimeException("Certification not found"));

        product.setProducer(producer);
        product.setCertification(certification);
        return repo.save(product);
    }

    public Product update(Long id, Product newData) {
        return repo.findById(id).map(p -> {
            p.setName(newData.getName());
            p.setType(newData.getType());
            p.setDescription(newData.getDescription());
            p.setPrice(newData.getPrice());
            p.setProducer(newData.getProducer());
            return repo.save(p);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Product> getByProducer(Long producerId) {
        return repo.findByProducer_Id(producerId);
    }

    public List<Product> getByType(String type) {
        return repo.findByType(type);
    }
}
