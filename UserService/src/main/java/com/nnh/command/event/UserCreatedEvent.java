package com.nnh.command.event;

import com.nnh.command.model.entity.RoleEntity;

public class UserCreatedEvent {
	private String fullName;
	private String username;
	private String password;
	private Integer age;
	private RoleEntity role;
	private String email;
	private Long phoneNum;
	private boolean isActive;
	
	public UserCreatedEvent(String fullName, String username, String password, RoleEntity role, String email,
			Long phoneNum, boolean isActive) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phoneNum = phoneNum;
		this.isActive = isActive;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
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
