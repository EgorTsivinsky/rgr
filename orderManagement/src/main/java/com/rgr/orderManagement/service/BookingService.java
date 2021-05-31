package com.rgr.orderManagement.service;

import com.rgr.orderManagement.entity.Booking;

public interface BookingService extends GenericService<Booking> {
    Booking findByDate(String date);
}