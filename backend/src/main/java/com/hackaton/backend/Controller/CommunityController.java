package com.hackaton.backend.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.backend.Entity.Community;
import com.hackaton.backend.Entity.Producer;
import com.hackaton.backend.Service.CommunityService;



@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    private final CommunityService service;
    

    public CommunityController(CommunityService service) {
        this.service = service;
    }

    @GetMapping
    public List<Community> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Community create(@RequestBody Community community) {
        return service.save(community);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Community> getByName(@PathVariable String name) {
        return service.getByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   @GetMapping("/{communityId}/producers")
    public ResponseEntity<List<Producer>> getProducersForCommunity(@PathVariable Long communityId) {
        List<Producer> producers = service.getProducersByCommunityId(communityId);
        if (producers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(producers, HttpStatus.OK);
    }
    
}

