package com.fitness.activityservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class UserValidationService {

    private static final Logger log = LogManager.getLogger(UserValidationService.class);
    @Autowired
    private WebClient userServiceWebClient;

    public boolean validateUser(String userId){
        log.info("Validating user with ID: {}", userId);
        try{
            Boolean exists = userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
            return exists != null && exists;
        } catch (WebClientResponseException e){
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("User not found: "+userId);
            }else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new RuntimeException("Invalid Request: "+userId);
            }
            return false;
        }

    }

}
