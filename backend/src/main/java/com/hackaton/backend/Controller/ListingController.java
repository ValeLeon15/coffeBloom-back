package com.hackaton.backend.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.backend.Entity.Listing;
import com.hackaton.backend.Service.ListingService;


@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService service;

    public ListingController(ListingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Listing> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Listing> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Listing create(@RequestBody Listing listing) {
        return service.save(listing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<Listing> byUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    @GetMapping("/status/{status}")
    public List<Listing> byStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }
}

