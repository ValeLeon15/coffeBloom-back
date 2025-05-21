package com.hackaton.backend.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_Order")
public class purchase_Order {
@Id
 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private Integer quantity;
    private Double totalAmount;
    private String status; // paid, shipped, delivered

   

    @ManyToOne
    private PlatformUser user;



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



    public PlatformUser getuser() {
        return user;
    }



    public void setuser(PlatformUser user) {
        this.user = user;
    }



    public purchase_Order(LocalDate orderDate, Integer quantity, Double totalAmount, String status, PlatformUser user) {
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
        this.user = user;
    }



    public purchase_Order() {
    }


    
}
