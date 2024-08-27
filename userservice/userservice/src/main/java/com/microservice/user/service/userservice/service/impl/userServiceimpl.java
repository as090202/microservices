package com.microservice.user.service.userservice.service.impl;

import com.microservice.user.service.userservice.entities.Hotel;
import com.microservice.user.service.userservice.entities.Rating;
import com.microservice.user.service.userservice.entities.user;
import com.microservice.user.service.userservice.exceptions.ResourcenotFoundexception;
import com.microservice.user.service.userservice.external.externalservices.HotelService;
import com.microservice.user.service.userservice.repository.UserRepository;
import com.microservice.user.service.userservice.service.userService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceimpl implements userService {
    @Autowired
    private UserRepository userRepository;
@Autowired
    private RestTemplate restTemplate;

 @Autowired
    private HotelService hotelService;

 private Logger logger= LoggerFactory.getLogger(userServiceimpl.class);
    @Override
    public user saveUser(user u) {
//        String randomUserId= UUID.randomUUID().toString();
//       user.setUsername(randomUserId);
        return userRepository.save(u);
    }

    @Override
    public List<user> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public user getUser(String userId) {

        user u=userRepository.findById(userId).orElseThrow(()->new ResourcenotFoundexception("user with given Id is not found on server"+userId));

       Rating[] forObject= restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+u.getUserId(), Rating[].class);
       logger.info("{} ",forObject);
       List<Rating> ratings= Arrays.stream(forObject).toList();

       List<Rating> ratingList=ratings.stream().map(rating -> {
           //System.out.println((rating.getHotelId()));
ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/api/"+rating.getHotelId(), Hotel.class);
             Hotel hotel= forEntity.getBody();
              logger.info("response status code:{}",forEntity.getStatusCode());
              rating.setHotel(hotel);

              return rating;
               }).collect((Collectors.toList()));

       u.setRatings(ratingList);
        return u;
    }
}
