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

import com.hackaton.backend.Entity.Producer;
import com.hackaton.backend.Service.ProducerService;

@RestController
@RequestMapping("/api/producers")
public class ProducerController {

    private final ProducerService service;

    public ProducerController(ProducerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producer create(@RequestBody Producer producer) {
        return service.save(producer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/community/{communityId}")
    public List<Producer> byCommunity(@PathVariable Long communityId) {
        return service.getByCommunity(communityId);
    }
}

