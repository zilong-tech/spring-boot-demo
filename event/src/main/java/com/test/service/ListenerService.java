package com.test.service;


import com.test.event.TestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ListenerService {

    @EventListener
    @Async("asyncExecutor")
    public void listener(TestEvent event) throws InterruptedException {
        Thread.sleep(5000);
        log.info("监听到数据：{}", event.getMessage());
    }
}
