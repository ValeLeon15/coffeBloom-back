package com.hackaton.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.backend.Entity.Feedback;
import com.hackaton.backend.Entity.purchase_Order;
import com.hackaton.backend.Entity.PlatformUser;
import com.hackaton.backend.Repository.FeedbackRepository;
import com.hackaton.backend.Repository.OrderRepository;
import com.hackaton.backend.Repository.PlatformRepository;

@Service
public class FeedbackService {
    private final FeedbackRepository repo;
    private final OrderRepository orderrepo;
    private final PlatformRepository userrepo;
    

    public FeedbackService(FeedbackRepository repo,OrderRepository orderrepo,PlatformRepository userrepo) {
        this.repo = repo;
        this.orderrepo=orderrepo;
        this.userrepo=userrepo;
    }

    public List<Feedback> getAll() {
        return repo.findAll();
    }

    public Optional<Feedback> getById(Long id) {
        return repo.findById(id);
    }

    public List<Feedback> getByUser(Long userId) {
        return repo.findByUser_Id(userId);
    }

    public List<Feedback> getByRating(int minRating) {
        return repo.findByRatingGreaterThanEqual(minRating);
    }

    public Feedback save(Feedback feedback) {

        purchase_Order order = orderrepo.findById(feedback.getOrder().getId())
        .orElseThrow(()-> new RuntimeException("Order wasn't found"));

        PlatformUser user = userrepo.findById(feedback.getUser().getId())
        .orElseThrow(() -> new RuntimeException("User wasn't found"));

        feedback.setOrder(order);
        feedback.setUser(user);


        return repo.save(feedback);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
