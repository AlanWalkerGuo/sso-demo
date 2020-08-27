package com.guosh.sso.client;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2RestOperations;

import java.util.List;
import java.util.Map;

/**
 * @Author: Guosh
 * @Date: 2020/7/10 18:23
 */
@Configuration
@EnableOAuth2Sso
@Order(4)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthoritiesExtractor authoritiesExtractor(OAuth2RestOperations template) {
        return new AuthoritiesExtractor() {
            @Override
            public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
                return null;
            }
        };
    }
}
