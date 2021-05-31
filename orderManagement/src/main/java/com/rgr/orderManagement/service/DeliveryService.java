package com.rgr.orderManagement.service;

import com.rgr.orderManagement.entity.Delivery;

public interface DeliveryService extends GenericService<Delivery> {
    Delivery findByName(String name);
}
