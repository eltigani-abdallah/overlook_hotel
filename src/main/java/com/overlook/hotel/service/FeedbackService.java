package com.overlook.hotel.service;

import com.overlook.hotel.Entity.Feedback;
import com.overlook.hotel.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    // CRUD: READ (Retrieve all feedbacks from the database)
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // CRUD: READ (Retrieve a feedback by its ID)
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    // CRUD: CREATE (Save a new feedback to the database)
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // CRUD: UPDATE (Update an existing feedback in the database)
    public Feedback updateFeedback(Long id, Feedback details) {
        Feedback feedback = getFeedbackById(id);
        feedback.setMessage(details.getMessage());      
        feedback.setStars(details.getStars());           
        feedback.setFeedbackDate(details.getFeedbackDate()); 
        feedback.setClient(details.getClient());         
        return feedbackRepository.save(feedback);
    }

    // CRUD: DELETE (Remove a feedback from the database by its ID)
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
