package com.hackaton.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.Entity.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
    List<Producer> findByCommunity_Id(Long communityId);
}
