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

import com.hackaton.backend.Entity.Feedback;
import com.hackaton.backend.Service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @GetMapping
    public List<Feedback> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return service.save(feedback);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<Feedback> byUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    @GetMapping("/rating/{min}")
    public List<Feedback> byRating(@PathVariable int min) {
        return service.getByRating(min);
    }
}
