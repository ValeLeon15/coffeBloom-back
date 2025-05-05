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

import com.hackaton.backend.Entity.Traceability;
import com.hackaton.backend.Service.TraceabilityService;

@RestController
@RequestMapping("/api/traceability")
public class TraceabilityController {

    private final TraceabilityService service;

    public TraceabilityController(TraceabilityService service) {
        this.service = service;
    }

    @GetMapping
    public List<Traceability> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traceability> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Traceability create(@RequestBody Traceability record) {
        return service.save(record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/product/{productId}")
    public List<Traceability> byProduct(@PathVariable Long productId) {
        return service.getByProduct(productId);
    }
}

