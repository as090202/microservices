package com.microservice.user.service.userservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro-users")
public class user {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private String userId;

    @Column(name="NAME")
    private String name;



    @Column(name="EMAIL")
    private String email;

    @Column(name="ABOUT")
    private String about;

@Transient
private List<Rating> ratings=new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
