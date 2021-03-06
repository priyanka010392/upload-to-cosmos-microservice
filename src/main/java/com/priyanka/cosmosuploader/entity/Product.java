package com.priyanka.cosmosuploader.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@Container(containerName = "products"/*, ru = "400"*/)
public class Product {

    @Id
    @PartitionKey
    private String productId;

    private String productName;

    private double price;

    private String productCategory;
}
