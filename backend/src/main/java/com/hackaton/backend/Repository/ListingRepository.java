package com.hackaton.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.Entity.Listing;


@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByUser_Id(Long userId);
    List<Listing> findByStatus(String status);
    
}