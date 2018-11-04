package com.ltmicro.auth.userdetails.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private boolean deleted;
    private String[] urls;
}
