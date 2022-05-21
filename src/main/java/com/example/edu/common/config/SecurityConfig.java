package com.example.edu.common.config;

import com.example.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
//public class SecurityConfig{
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;




    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()   //所有人都可以访问
                .antMatchers("/home").hasAnyRole("student","teacher")   //需要有权限才能够访问
//                .antMatchers("/").hasAnyRole("student","teacher")
                .antMatchers("/teacher/**").hasRole("teacher") //需要教师权限才能访问
                .antMatchers("/student/**","/getUser").hasAnyAuthority("student");  //需要学生权限才能访问

        http.formLogin()
                .loginPage("/login")
                .usernameParameter("userName")
                .passwordParameter("passWord");


        http.logout()
                .logoutSuccessUrl("/");    //注销后重定向

        http.rememberMe().rememberMeParameter("remember");  //开启记住我功能
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }


}
