package com.priyanka.cosmosuploader.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.priyanka.cosmosuploader.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
}
