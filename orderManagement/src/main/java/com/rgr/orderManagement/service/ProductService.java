package com.rgr.orderManagement.service;

import com.rgr.orderManagement.entity.Product;

public interface ProductService extends GenericService<Product> {
    Product findByName(String name);
}
