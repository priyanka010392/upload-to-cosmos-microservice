package com.priyanka.cosmosuploader.config;

import com.azure.cosmos.ChangeFeedProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class ChangeFeedProcessorInitializer {

    @Autowired
    private ChangeFeedConfigBuilder changeFeedConfigBuilder;

    private ChangeFeedProcessor changeFeedProcessor;

    @PostConstruct
    public void startChangeFeedProcessor() {
        try {
            log.info("^^^^^^^^^^^ Subscribed ChangeFeed starting.. ^^^^^^^^^^^^^^^^^^");
            changeFeedProcessor = changeFeedConfigBuilder.build();
            if(changeFeedProcessor != null)
                changeFeedProcessor.start().block();
            else
                log.warn("changeFeedProcessor is null.. probably changeFeedProcessor has not been setup yet");
            log.info("^^^^^^^^^^^ Subscribed to changeFeed is successful ^^^^^^^^^^^^^^^^^^");
        } catch (Exception e) {
            log.error("Error occurred while starting changeFeedProcessor.", e);
            throw e;
        }
    }

    @PreDestroy
    public void stopChangeFeedProcessor () {
        log.info("Shutting down change feed.");
        if(changeFeedProcessor != null)
            changeFeedProcessor.stop().block();
        else
            log.warn("changeFeedProcessor is null.. probably changeFeedProcessor has not been started yet");
    }
}
