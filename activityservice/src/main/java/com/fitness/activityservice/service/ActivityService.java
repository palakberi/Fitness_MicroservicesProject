package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ActivityService {

    private static final Logger log = LogManager.getLogger(ActivityService.class);
    @Autowired
    private ActivityRepository repository;
    @Autowired
    private UserValidationService userValidationService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;


    public ActivityResponse trackActivity(ActivityRequest request) {
        boolean isValidUser = userValidationService.validateUser(request.getUserId());
        if (!isValidUser) {
            throw new RuntimeException("Invalid User ID: " + request.getUserId());
        }

        Activity activity = new Activity();
        activity.setUserId(request.getUserId());
        activity.setDuration(request.getDuration());
        activity.setType(request.getType());
        activity.setCaloriesBurnt(request.getCaloriesBurnt());
        activity.setStartTime(request.getStartTime());
        activity.setAdditionalMetrices(request.getAdditionalMetrices());
        Activity savedActivity = repository.save(activity);

        //Publish to rabbitmq for ai processing
        try{
            rabbitTemplate.convertAndSend(exchange, routingKey, savedActivity);
        }catch(Exception e){
            log.error("Failed to publish activity to RabbitMQ", e);
        }
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUserId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurnt(activity.getCaloriesBurnt());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrices(activity.getAdditionalMetrices());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;
    }

    public List<ActivityResponse> getUserActivities(String usedId) {
        List<Activity> activities=repository.findByUserId(usedId);
        return activities.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ActivityResponse getActivityById(String activityId) {
        return repository.findById(activityId)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }
}
