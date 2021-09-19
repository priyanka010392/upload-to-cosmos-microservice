package com.priyanka.cosmosuploader.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.priyanka.cosmosuploader.entity.Inventory;

public interface InventoryRepository extends CosmosRepository<Inventory, String> {

}
