package com.priyanka.cosmosuploader.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Container(containerName = "lease")
public class Lease {

    @PartitionKey
    private String id;
}
