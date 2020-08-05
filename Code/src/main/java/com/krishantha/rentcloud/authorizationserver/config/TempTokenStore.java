package com.krishantha.rentcloud.authorizationserver.config;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

public class TempTokenStore extends JdbcTokenStore{

	public TempTokenStore(DataSource dataSource) {
		super(dataSource);
	}
	
	public OAuth2AccessToken readAccessToken(String tokenValue) {
		OAuth2AccessToken accessToken = null;
		
		try {
			accessToken = new DefaultOAuth2AccessToken(accessToken);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return accessToken;
	}

}
