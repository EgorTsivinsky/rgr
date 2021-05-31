package com.rgr.orderManagement.service.impl;

import com.rgr.orderManagement.entity.Booking;
import com.rgr.orderManagement.repository.BookingRepository;
import com.rgr.orderManagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;


    @Override
    public Booking findByDate(String date) {
        return bookingRepository.findBookingByDate(date);
    }

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findBookingById(id);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}
