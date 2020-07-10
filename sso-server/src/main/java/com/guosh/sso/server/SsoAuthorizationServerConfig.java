/**
 * 
 */
package com.guosh.sso.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author guosh
 *
 */
@Configuration
@EnableAuthorizationServer
public class SsoAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("client1")
				.secret("clientsecret1")
				.authorizedGrantTypes("authorization_code", "refresh_token","password")
				.scopes("all")
				.autoApprove(true)
				.and()
				.withClient("client2")
				.secret("clientsecret2")
				.authorizedGrantTypes("authorization_code", "refresh_token","password")
				.autoApprove(true)
				.scopes("all");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
//		endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
	}



	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.allowFormAuthenticationForClients();
	}



//	@Bean
//	public TokenStore jwtTokenStore() {
//		return new JwtTokenStore(jwtAccessTokenConverter());
//	}
//
//	@Bean
//	public JwtAccessTokenConverter jwtAccessTokenConverter(){
//		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("jwtdemo");
//        return converter;
//	}

}
