package com.example.edu.controller;

import com.example.edu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/student")
public class StudentController {

//    @Autowired
//    StudentSe

    @GetMapping("/center")
    public String getStudent(String name){
        return "";
    }

}
