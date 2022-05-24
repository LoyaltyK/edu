package com.example.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private int studentId;
    private String name;
    private String sex;
    private Date birthDay;
    private Date grade;
    private String collegeName;


    public void setStudentId(int studentId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String year = simpleDateFormat.format(new Date());
        this.studentId = Integer.parseInt((year+this.id));
    }
}
