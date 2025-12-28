package com.fitness.activityservice.dto;

import com.fitness.activityservice.model.ActivityType;

import java.time.LocalDateTime;
import java.util.Map;

public class ActivityRequest {
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurnt;
    private LocalDateTime startTime;
    private Map<String,Object> additionalMetrices;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public ActivityType getType() {
        return type;
    }
    public void setType(ActivityType type) {
        this.type = type;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public Integer getCaloriesBurnt() {
        return caloriesBurnt;
    }
    public void setCaloriesBurnt(Integer caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public Map<String, Object> getAdditionalMetrices() {
        return additionalMetrices;
    }
    public void setAdditionalMetrices(Map<String, Object> additionalMetrices) {
        this.additionalMetrices = additionalMetrices;
    }

}
