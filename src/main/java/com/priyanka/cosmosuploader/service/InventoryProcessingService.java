package com.priyanka.cosmosuploader.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.priyanka.cosmosuploader.entity.Inventory;
import com.priyanka.cosmosuploader.entity.Product;
import com.priyanka.cosmosuploader.repository.InventoryRepository;
import com.priyanka.cosmosuploader.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryProcessingService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    public void processInventory(JsonNode document) {
        log.info(document.toPrettyString());
        Inventory inventory = new Inventory();
        inventory.setInventoryId(document.get("productId").asText());
        inventory.setInventoryName(document.get("productName").asText());
        inventory.setPrice(document.get("price").asDouble());
        inventory.setCategory(document.get("productCategory").asText());
        inventoryRepository.save(inventory);
    }

    public void addProdcut(Product product) {
        productRepository.save(product);
    }
}
