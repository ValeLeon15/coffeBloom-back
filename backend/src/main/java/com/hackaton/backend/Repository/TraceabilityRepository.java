package com.hackaton.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.Entity.Traceability;

@Repository
public interface TraceabilityRepository extends JpaRepository<Traceability, Long> {
    List<Traceability> findByProduct_Id(Long productId);
}
