package com.hackaton.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Community;
import com.hackaton.backend.Entity.Producer;
import com.hackaton.backend.Repository.CommunityRepository;
import com.hackaton.backend.Repository.ProducerRepository;

@Service
public class CommunityService {
    private final CommunityRepository repo;
    private final ProducerRepository producerRepository;

    public CommunityService(CommunityRepository repo, ProducerRepository produceRepository) {
        this.repo = repo;
        this.producerRepository=produceRepository;
    }

    public List<Community> getAll() {
        return repo.findAll();
    }

    public Optional<Community> getById(Long id) {
        return repo.findById(id);
    }

    public Community save(Community community) {
        return repo.save(community);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Optional<Community> getByName(String name) {
        return repo.findByName(name);
    }
    public List<Producer> getProducersByCommunityId(Long communityId) {
        return producerRepository.findByCommunity_Id(communityId);
    }
}

