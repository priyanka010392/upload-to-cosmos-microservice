//package com.priyanka.cosmosuploader.config;
//
//import com.azure.data.cosmos.ConnectionMode;
//import com.azure.data.cosmos.CosmosClient;
//import com.azure.data.cosmos.internal.http.HttpClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CosmosClientConfig {
//
//    @Bean
//    CosmosClient getCosmosClient() {
//        CosmosClientOptions cosmosClientOptions = new CosmosClientOptions()
//        {
//            HttpClientFactory = () =>
//            {
//                HttpMessageHandler httpMessageHandler = new HttpClientHandler()
//                {
//                    ServerCertificateCustomValidationCallback = HttpClientHandler.DangerousAcceptAnyServerCertificateValidator
//                };
//
//                return new HttpClient(httpMessageHandler);
//            },
//            ConnectionMode = ConnectionMode.Gateway
//        };
//
//
//        CosmosClient client = new CosmosClient(endpoint, authKey, cosmosClientOptions);
//    }
//}
