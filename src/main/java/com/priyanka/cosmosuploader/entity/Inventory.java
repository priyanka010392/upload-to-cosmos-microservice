package com.priyanka.cosmosuploader.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Container(containerName = "inventory")
public class Inventory {

    @PartitionKey
    private String category;

    @Id
    private String inventoryId;

    private String inventoryName;

    private double price;
}
