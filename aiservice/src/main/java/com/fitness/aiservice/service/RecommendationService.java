package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository repository;

    public List<Recommendation> getUserRecommendation(String userId) {
        return repository.findByUserId(userId);
    }

    public Recommendation getActivityRecommendation(String activityId) {
        return repository.findByActivityId(activityId)
                .orElseThrow(() -> new RuntimeException("Recommendation not found for activityId: " + activityId));
    }
}
