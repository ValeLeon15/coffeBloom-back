package com.hackaton.backend.Controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.backend.Entity.Certification;
import com.hackaton.backend.Service.CertificationService;

@RestController
@RequestMapping("/api/certifications")
public class CertificationController {

    private final CertificationService service;

    public CertificationController(CertificationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Certification> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Certification create(@RequestBody Certification cert) {
        return service.save(cert);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<Certification> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }
}
