package com.fitness.aiservice.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

public class Activity {
    @Id
    private String id;
    private String userId;
    private Integer duration;
    private Integer caloriesBurnt;
    private LocalDateTime startTime;

    @Field("metrices")
    private Map<String,Object> additionalMetrices;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}