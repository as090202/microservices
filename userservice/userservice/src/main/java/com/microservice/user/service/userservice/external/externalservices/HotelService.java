package com.microservice.user.service.userservice.external.externalservices;
//import com.microservice.user.service.entities.Rating;
import com.microservice.user.service.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/api/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
