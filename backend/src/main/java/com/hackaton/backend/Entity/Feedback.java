package com.hackaton.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Integer rating;

    @ManyToOne
    private purchase_Order order;

    @ManyToOne
    private PlatformUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public purchase_Order getOrder() {
        return order;
    }

    public void setOrder(purchase_Order order) {
        this.order = order;
    }

    public PlatformUser getUser() {
        return user;
    }

    public void setUser(PlatformUser user) {
        this.user = user;
    }

    public Feedback() {
    }

    public Feedback(Long id, String comment, Integer rating, purchase_Order order, PlatformUser user) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.order = order;
        this.user = user;
    }

   

    

    
}
