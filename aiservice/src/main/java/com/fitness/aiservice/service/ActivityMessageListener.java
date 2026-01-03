package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Activity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ActivityMessageListener {

    private static final Logger log = LogManager.getLogger(ActivityMessageListener.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void processActivity(Activity activity){
        log.info("Received activity for AI processing: " + activity.getId());

    }

}
