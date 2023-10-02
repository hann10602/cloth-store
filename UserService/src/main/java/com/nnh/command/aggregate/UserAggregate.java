package com.nnh.command.aggregate;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.nnh.command.command.CreateUserCommand;

@Aggregate
public class UserAggregate {
	@AggregateIdentifier
	private Long id;
	private String fullName;
	private String username;
	private String password;
	private String email;
	private Long phoneNum;
	private boolean isActive;
	
	public UserAggregate(CreateUserCommand command) {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
