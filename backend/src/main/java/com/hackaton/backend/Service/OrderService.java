package com.hackaton.backend.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.purchase_Order;
import com.hackaton.backend.Entity.PlatformUser;
import com.hackaton.backend.Repository.OrderRepository;
import com.hackaton.backend.Repository.PlatformRepository;

@Service
public class OrderService {

     private final PlatformRepository userrepo;

    private final OrderRepository orderRepository;

   

    public OrderService(OrderRepository orderRepository, PlatformRepository userrepo) {
        this.orderRepository = orderRepository;
        this.userrepo=userrepo;
      
    }

    public List<purchase_Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<purchase_Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    public purchase_Order save(purchase_Order order) {
     
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDate.now());
        }
         PlatformUser user = userrepo.findById(order.getuser().getId())
        .orElseThrow(() -> new RuntimeException ("User not found"));

         

        order.setuser(user);
      
       
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public List<purchase_Order> getByBuyer(Long buyerId) {
       
        return orderRepository.findByUser_Id(buyerId);
    }

   

    public void PayMockup(Long id) {
        Optional<purchase_Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            purchase_Order order = optionalOrder.get();
            
            order.setStatus("paid");
            orderRepository.save(order);
            System.out.println("Order " + id + " has been marked as paid (mockup).");
        } else {
            
            System.out.println("Order " + id + " not found for payment mockup.");
           
        }
    }
}