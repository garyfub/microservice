package com.ltmicro.auth.config.oauth2.token.jwt;

import com.ltmicro.auth.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
public class JWTConfig {

    @Autowired
    PropertyConfig propertyConfig;

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        LTJwtAccessTokenConverter jwtAccessTokenConverter = new LTJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(propertyConfig.getJwtSigningKey());
        return jwtAccessTokenConverter;
    }
}
