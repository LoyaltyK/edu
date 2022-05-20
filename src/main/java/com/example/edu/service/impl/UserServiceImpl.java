package com.example.edu.service.impl;

import com.example.edu.entity.User;
import com.example.edu.mapper.UserMapper;
import com.example.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = selectUserByName(username);
        if (user == null)
            return null;
        return new org.springframework.security.core.userdetails.User(user.getUserName(),passwordEncoder.encode(user.getPassWord()), AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
        //AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole())
    }
}
