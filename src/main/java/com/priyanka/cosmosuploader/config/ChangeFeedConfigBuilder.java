package com.priyanka.cosmosuploader.config;

import com.azure.cosmos.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChangeFeedConfigBuilder {

    @Value("my-host")
    private String hostName;
    @Value("${azure.cosmos.uri}")
    private String endpointUri;
    @Value("${azure.cosmos.key}")
    private String primaryKey;
    @Value("${azure.cosmos.database}")
    private String databaseName;
    @Value("${azure.cosmosdb.container.feed}")
    private String feedContainerName;
    @Value("${azure.cosmosdb.container.lease}")
    private String leaseContainerName;

    ChangeFeedProcessor build() {
        CosmosAsyncClient client =
                new CosmosClientBuilder()
                        .endpoint(endpointUri)
                        .key(primaryKey)
//                        .preferredRegions(Lists.newArrayList("South Central US"))
                        .consistencyLevel(ConsistencyLevel.SESSION)
                        .contentResponseOnWriteEnabled(true)
                        .buildAsyncClient();

        CosmosAsyncContainer feedContainer = client.getDatabase(databaseName).getContainer(feedContainerName);
        CosmosAsyncContainer leaseContainer = client.getDatabase(databaseName).getContainer(leaseContainerName);
        if (feedContainer == null || leaseContainer == null) {
            throw new IllegalArgumentException(
                    "Application could not start. feedContainer and/or leaseContainer is null.");
        }
        return buildChangeFeedProcessor(feedContainer, leaseContainer);
    }

    private ChangeFeedProcessor buildChangeFeedProcessor(CosmosAsyncContainer feedContainer,
                                                 CosmosAsyncContainer leaseContainer) {

        return new ChangeFeedProcessorBuilder()
                .hostName(hostName)
                .feedContainer(feedContainer)
                .leaseContainer(leaseContainer)
                .handleChanges(docs -> {
                    for (JsonNode item : docs) {
                        // Implementation for handling and processing of each JsonNode item goes here
                        processFeed(item);
                    }
                })
                .buildChangeFeedProcessor();
    }

    private void processFeed(JsonNode item) {
        //process
    }
}
