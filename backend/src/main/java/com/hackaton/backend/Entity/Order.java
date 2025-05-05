package com.hackaton.backend.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private Integer quantity;
    private Double totalAmount;
    private String status; // paid, shipped, delivered

    @OneToMany
    private List<Listing> listing;

    @ManyToOne
    private PlatformUser buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Listing> getListing() {
        return listing;
    }

    public void setListing(List<Listing> listing) {
        this.listing = listing;
    }

    public PlatformUser getBuyer() {
        return buyer;
    }

    public void setBuyer(PlatformUser buyer) {
        this.buyer = buyer;
    }

    public Order() {
    }

    public Order(Long id, LocalDate orderDate, Integer quantity, Double totalAmount, String status,
            List<Listing> listing, PlatformUser buyer) {
        this.id = id;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
        this.listing = listing;
        this.buyer = buyer;
    }

   
    
}
