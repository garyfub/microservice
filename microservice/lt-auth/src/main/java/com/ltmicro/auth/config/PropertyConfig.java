package com.ltmicro.auth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PropertyConfig {
    @Value("${lt.oauth2.jwt.signing-key}")
    private String jwtSigningKey = "";
    @Value("${lt.oauth2.jwt.token-store-type}")
    private String jwtTokenStoreType = "";
}
