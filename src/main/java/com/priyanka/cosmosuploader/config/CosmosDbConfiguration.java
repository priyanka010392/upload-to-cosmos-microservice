//package com.priyanka.cosmosuploader.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableCosmosRepositories(basePackages = "com.priyanka.cosmosuploader.repository")
//public class CosmosDbConfiguration extends AbstractCosmosConfiguration {
//
//    @Value("${azure.cosmos.uri}")
//    private String uri;
//
//    @Value("${azure.cosmos.key}")
//    private String key;
//
//    @Value("${azure.cosmos.database}")
//    private String dbName;
//
//    private CosmosKeyCredential cosmosKeyCredential;
//
//    @Bean
//    public CosmosDBConfig getConfig() {
//        this.cosmosKeyCredential = new CosmosKeyCredential(key);
//        CosmosDBConfig cosmosdbConfig = CosmosDBConfig.builder(uri, this.cosmosKeyCredential, dbName)
//                .build();
//        return cosmosdbConfig;
//    }
//}
