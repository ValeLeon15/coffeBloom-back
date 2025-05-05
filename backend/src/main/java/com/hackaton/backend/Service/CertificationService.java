package com.hackaton.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Certification;
import com.hackaton.backend.Repository.CertificationRepository;

@Service
public class CertificationService {
    private final CertificationRepository repo;

    public CertificationService(CertificationRepository repo) {
        this.repo = repo;
    }

    public List<Certification> getAll() {
        return repo.findAll();
    }

    public Certification save(Certification cert) {
        return repo.save(cert);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Certification> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
}

