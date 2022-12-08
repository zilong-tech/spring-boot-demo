package com.test.service;

import com.test.event.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        applicationEventPublisher.publishEvent(new TestEvent(message));
    }
}
