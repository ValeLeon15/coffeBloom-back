package com.hackaton.backend.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double priceUsd;
    private LocalDate publicationDate;
    private String status; // active, sold, paused

    @ManyToOne
    private Product product;

    @ManyToOne
    private PlatformUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PlatformUser getUser() {
        return user;
    }

    public void setUser(PlatformUser user) {
        this.user = user;
    }

    public Listing() {
    }

    public Listing(Long id, Double priceUsd, LocalDate publicationDate, String status, Product product,
            PlatformUser user) {
        this.id = id;
        this.priceUsd = priceUsd;
        this.publicationDate = publicationDate;
        this.status = status;
        this.product = product;
        this.user = user;
    }

    

    
}
