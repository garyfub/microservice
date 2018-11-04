package com.ltmicro.auth.config.oauth2.token;

import com.ltmicro.auth.config.PropertyConfig;
import com.ltmicro.auth.config.oauth2.token.store.MyRedisTokenStore;
import com.ltmicro.auth.constant.AuthConstants;
import com.ltmicro.auth.userdetails.entity.UserDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class TokenConfig {

    @Autowired
    PropertyConfig propertyConfig;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public TokenStore tokenStore() {
        if ("redis".equals(propertyConfig.getJwtTokenStoreType())) {
            MyRedisTokenStore tokenStore = new MyRedisTokenStore(redisConnectionFactory);
            tokenStore.setPrefix(AuthConstants.REDIS_PREFIX);
            return tokenStore;
        } else
            return new InMemoryTokenStore();
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new TokenEnhancer() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
                if (oAuth2AccessToken instanceof DefaultOAuth2AccessToken) {
                    DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) oAuth2AccessToken;
                    Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();

                    additionalInformation.put("license", AuthConstants.LICENSE);
                    UserDetailsEntity user = (UserDetailsEntity) oAuth2Authentication.getUserAuthentication().getPrincipal();
                    if (user != null) {
                        additionalInformation.put("userId", user.getUserId());
                    }
                    token.setAdditionalInformation(additionalInformation);
                }
                return oAuth2AccessToken;
            }
        };
    }

}
