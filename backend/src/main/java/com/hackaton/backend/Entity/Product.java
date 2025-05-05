package com.hackaton.backend.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // e.g., chocolate, coffee, cosmetics
    private String description;
    private double Price;

    private LocalDate productionDate;
    private LocalDate expirationDate;
    private String principalIngredients;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Certification certification;

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPrincipalIngredients() {
        return principalIngredients;
    }

    public void setPrincipalIngredients(String principalIngredients) {
        this.principalIngredients = principalIngredients;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public Product() {
    }

    public Product(Long id, String name, String type, String description, double price, LocalDate productionDate,
            LocalDate expirationDate, String principalIngredients, Producer producer, Certification certification) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        Price = price;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.principalIngredients = principalIngredients;
        this.producer = producer;
        this.certification = certification;
    }

}
