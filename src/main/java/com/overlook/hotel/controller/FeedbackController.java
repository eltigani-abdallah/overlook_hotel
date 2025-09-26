package com.overlook.hotel.controller;

import com.overlook.hotel.Entity.Feedback;
import com.overlook.hotel.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedbacks") // REST API base endpoint for feedbacks
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    // REST API: GET (Retrieve all feedbacks) -- CRUD: READ
    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    // REST API: GET (Retrieve a feedback by ID) -- CRUD: READ
    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    // REST API: POST (Create a new feedback) -- CRUD: CREATE
    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    // REST API: PUT (Update an existing feedback) -- CRUD: UPDATE
    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    // REST API: DELETE (Delete a feedback by ID) -- CRUD: DELETE
    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}
