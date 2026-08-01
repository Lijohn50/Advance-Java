package com.example.hotel_booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    List<Guest> findAllByBooking_PaymentStatus(String paymentStatus);
}
