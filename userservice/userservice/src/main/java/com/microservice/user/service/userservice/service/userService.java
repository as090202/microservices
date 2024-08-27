package com.microservice.user.service.userservice.service;

import com.microservice.user.service.userservice.entities.user;
import org.apache.catalina.User;
import java.util.List;

public interface userService {

    user saveUser(user u);
    List<user> getAllUser();
    user getUser(String userId);
}
