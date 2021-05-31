package com.rgr.orderManagement.repository;

import com.rgr.orderManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    Product findProductByName(String name);
}
