package com.example.edu.controller;

import com.example.edu.entity.User;
import com.example.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){
        return userService.selectUserByName("zs");
    }

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping(value = {"/login","/"})
    public String login(){
        return "Login";
    }

}
