package com.priyanka.cosmosuploader.controller;

import com.priyanka.cosmosuploader.entity.Product;
import com.priyanka.cosmosuploader.service.InventoryProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class InventoryManagementController {

    @Autowired
    InventoryProcessingService inventoryProcessingService;

    @PostMapping(value = {"/product"})
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        try {
            inventoryProcessingService.addProdcut(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }
}
