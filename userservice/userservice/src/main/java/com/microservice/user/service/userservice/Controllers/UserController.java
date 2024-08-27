package com.microservice.user.service.userservice.Controllers;

import com.microservice.user.service.userservice.entities.user;
import com.microservice.user.service.userservice.service.userService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private userService UserService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/adduser")
    public ResponseEntity<user> createUser(@RequestBody user u){

        user user1=UserService.saveUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<user> getSingleUser(@PathVariable String userId){
        System.out.println(userId);
        user u=UserService.getUser(userId);
        return ResponseEntity.ok(u);

    }




    @GetMapping
    public ResponseEntity<List<user>> getAllUser(){
        List<user> allUser=UserService.getAllUser();
        return ResponseEntity.ok(allUser);

    }
}
