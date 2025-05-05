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

import com.hackaton.backend.Entity.PlatformUser;
import com.hackaton.backend.Service.PlatformUserService;

@RestController
@RequestMapping("/api/users")
public class PlatformUserController {

    private final PlatformUserService service;

    public PlatformUserController(PlatformUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlatformUser> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformUser> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlatformUser create(@RequestBody PlatformUser user) {
        return service.save(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PlatformUser> getByEmail(@PathVariable String email) {
        return service.getByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

