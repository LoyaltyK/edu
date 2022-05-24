package com.example.edu;

import com.example.edu.entity.User;
import com.example.edu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class EduApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
//        User zs = userMapper.selectUserByName("zs");
//        System.out.println(zs);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(simpleDateFormat.format(new Date()));
        System.out.println(year);
    }




}
