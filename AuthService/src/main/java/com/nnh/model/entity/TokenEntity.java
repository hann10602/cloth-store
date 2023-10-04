package com.nnh.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class TokenEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String token;
	private String username;
	private String password;
	
	public TokenEntity(Builder builder) {
		this.token = builder.token;
		this.username = builder.username;
		this.password = builder.password;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static class Builder {
		private String token;
		private String username;
		private String password;
		
		public Builder token(String token) {
			return this;
		}
		public Builder username(String username) {
			return this;
		}
		public Builder password(String password) {
			return this;
		}
		
		public TokenEntity build() {
			return new TokenEntity(this);
		}
	}
} 
