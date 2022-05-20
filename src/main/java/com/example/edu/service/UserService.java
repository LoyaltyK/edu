package com.example.edu.service;

import com.example.edu.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User selectUserByName(String name);
}
