package com.priyanka.cosmosuploader.repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
import com.priyanka.cosmosuploader.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
}
