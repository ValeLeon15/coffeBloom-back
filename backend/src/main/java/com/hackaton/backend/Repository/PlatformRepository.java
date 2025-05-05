package com.hackaton.backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.Entity.PlatformUser;

@Repository
public interface PlatformRepository extends JpaRepository<PlatformUser, Long> {
    Optional<PlatformUser> findByEmail(String email);
}
