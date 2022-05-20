package com.example.edu;

import com.example.edu.entity.User;
import com.example.edu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EduApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User zs = userMapper.selectUserByName("zs");
        System.out.println(zs);
    }

}
