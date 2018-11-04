package com.ltmicro.auth.userdetails.service.impl;

import com.ltmicro.auth.userdetails.dto.UserDTO;
import com.ltmicro.auth.userdetails.entity.UserDetailsEntity;
import com.ltmicro.auth.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO userDTO = userService.getUser(username);

        if (null == userDTO) throw new UsernameNotFoundException("用户不存在");

        UserDetailsEntity user = new UserDetailsEntity();
        user.setUserId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setDeleted(userDTO.isDeleted());
        user.setUrls(userDTO.getUrls());

        return user;
    }

}