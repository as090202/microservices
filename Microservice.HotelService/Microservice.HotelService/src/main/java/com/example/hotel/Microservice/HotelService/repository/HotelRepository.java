package com.example.hotel.Microservice.HotelService.repository;

import com.example.hotel.Microservice.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
