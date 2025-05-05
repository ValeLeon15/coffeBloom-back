package com.hackaton.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Community;
import com.hackaton.backend.Entity.Producer;
import com.hackaton.backend.Repository.CommunityRepository;
import com.hackaton.backend.Repository.ProducerRepository;

@Service
public class ProducerService {

    private final ProducerRepository producerRepository;
    private final CommunityRepository communityRepository;

    public ProducerService(ProducerRepository producerRepository, CommunityRepository communityRepository) {
        this.producerRepository = producerRepository;
        this.communityRepository=communityRepository;
    }

    public List<Producer> getAll() {
        return producerRepository.findAll();
    }

    public Producer save(Producer producer) {
        Community com = communityRepository.findById(producer.getCommunity().getId())
        .orElseThrow(() -> new RuntimeException("Community not found"));

        producer.setCommunity(com);
        return producerRepository.save(producer);
    }

    public Optional<Producer> getById(Long id) {
        return producerRepository.findById(id);
    }

    public void delete(Long id) {
        producerRepository.deleteById(id);
    }
    public List<Producer> getByCommunity(Long communityId) {
        return producerRepository.findByCommunity_Id(communityId);
    }
}

