package com.hackaton.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.Entity.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    List<Certification> findByNameContainingIgnoreCase(String name);
}
