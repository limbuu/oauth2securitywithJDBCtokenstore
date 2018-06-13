package com.security.oauth2.oauth2security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	@Value("${security.oauth2.client_id}")
	private  String client_id;
	
	@Value("${security.oauth2.client_secret}")
	private  String client_secret;
	
	@Value("${security.oauth2.grant_type}")
	private  String grant_type;
	
	@Value("${security.oauth2.authorization_code}")
	private String authorization_code;
	
	@Value("${security.oauth2.refresh_token}")
	private  String refresh_token;
	
	@Value("${security.oauth2.implicit}")
	private  String implicit;
	
	@Value("${security.oauth2.scope_read}")
	private  String scope_read;
	
	@Value("${security.oauth2.scope_write}")
	private String scope_write;
	
	@Value("${security.oauth2.trust}")
	private  String trust;
	
	@Value("#{new Integer('${security.oauth2.access_token_validity_seconds}')}")
	private  int access_token_validity_seconds;
	
	@Value("#{new Integer('${security.oauth2.refresh_token_validity_seconds}')}")
	private  int refresh_token_validity_seconds;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenStore tokenStore;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient(client_id)
		.secret(client_secret)
		.authorizedGrantTypes(grant_type,authorization_code, refresh_token, implicit )
		.scopes(scope_read,scope_write,trust)
		.accessTokenValiditySeconds(access_token_validity_seconds)
		.refreshTokenValiditySeconds(refresh_token_validity_seconds);
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
	}

}
