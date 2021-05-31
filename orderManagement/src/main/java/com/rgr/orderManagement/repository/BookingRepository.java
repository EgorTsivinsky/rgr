package com.rgr.orderManagement.repository;

import com.rgr.orderManagement.entity.Booking;
import com.rgr.orderManagement.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "booking", path = "booking")
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findBookingById(Long id);

    Booking findBookingByDate(String date);
}