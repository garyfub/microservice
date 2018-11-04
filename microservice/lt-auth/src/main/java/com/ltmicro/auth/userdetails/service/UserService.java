package com.ltmicro.auth.userdetails.service;

import com.ltmicro.auth.userdetails.dto.UserDTO;

public interface UserService {
    UserDTO getUser(String userName);
}
