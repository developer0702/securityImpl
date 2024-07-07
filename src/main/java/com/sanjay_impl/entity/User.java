package com.sanjay_impl.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "email_address",nullable = false,unique = true)
    private String email;
    @Column(name = "user_details")
    private String about;

    private String password;

    private String roles;


}
