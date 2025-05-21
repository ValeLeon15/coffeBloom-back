package com.hackaton.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.Entity.purchase_Order;

@Repository
public interface OrderRepository extends JpaRepository<purchase_Order, Long> {
    List<purchase_Order> findByUser_Id(Long userId);
    
}
