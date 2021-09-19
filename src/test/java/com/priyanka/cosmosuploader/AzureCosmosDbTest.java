package com.priyanka.cosmosuploader;

import com.azure.cosmos.models.PartitionKey;
import com.priyanka.cosmosuploader.entity.Product;
import com.priyanka.cosmosuploader.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AzureCosmosDbTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void getProductTest() {
        Product product = new Product();
        product.setProductId("1001");
        product.setProductCategory("Shirt");
        product.setPrice(110.0);
        product.setProductName("Blue Shirt");
        productRepository.save(product);

        Product retrievedProduct = productRepository.findById("1001", new PartitionKey("Shirt"))
                .orElse(null);
        log.info("Retrieved Product: {}", retrievedProduct);
        Assert.notNull(retrievedProduct, "Retrieved Product is Null");
    }
}
