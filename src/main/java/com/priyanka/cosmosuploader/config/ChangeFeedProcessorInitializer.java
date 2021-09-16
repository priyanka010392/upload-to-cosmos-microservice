package com.priyanka.cosmosuploader.config;

import com.azure.cosmos.ChangeFeedProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ChangeFeedProcessorInitializer {

    @Autowired
    private ChangeFeedConfigBuilder changeFeedConfigBuilder;

    private ChangeFeedProcessor changeFeedProcessor;

    @PostConstruct
    public void startChangeFeedProcessor() {
        try {
            changeFeedProcessor = changeFeedConfigBuilder.build();
            if(changeFeedProcessor != null)
                changeFeedProcessor.start().block();
            else
                System.out.println("changeFeedProcessor is null");
        } catch (Exception e) {
            throw e;
        }
    }

    @PreDestroy
    public void stopChangeFeedProcessor () {
        if(changeFeedProcessor != null)
            changeFeedProcessor.stop().block();
        else
            System.out.println("changeFeedProcessor is null");
    }
}
