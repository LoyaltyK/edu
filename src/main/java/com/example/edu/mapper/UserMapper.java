package com.example.edu.mapper;

import com.example.edu.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByName(String userName);

    User selectById(int id);
}
