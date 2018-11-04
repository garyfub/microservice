package com.ltmicro.auth.userdetails.service.impl;

import com.ltmicro.auth.userdetails.dto.UserDTO;
import com.ltmicro.auth.userdetails.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO getUser(String userName) {
        if (userName.equals("username")) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId((long) 30);
            userDTO.setUsername("username");
            userDTO.setPassword("123");
            userDTO.setDeleted(false);
            userDTO.setUrls(new String[]{
                    "[GET]/srva/test"
            });
            return userDTO;
        } else
            return null;
    }
}