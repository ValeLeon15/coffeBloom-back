package com.hackaton.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.PlatformUser;
import com.hackaton.backend.Repository.PlatformRepository;

@Service
public class PlatformUserService {
    private final PlatformRepository repo;

    public PlatformUserService(PlatformRepository repo) {
        this.repo = repo;
    }

    public List<PlatformUser> getAll() {
        return repo.findAll();
    }

    public Optional<PlatformUser> getById(Long id) {
        return repo.findById(id);
    }

    public PlatformUser save(PlatformUser user) {
        return repo.save(user);
    }

    public Optional<PlatformUser> getByEmail(String email) {
        return repo.findByEmail(email);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
