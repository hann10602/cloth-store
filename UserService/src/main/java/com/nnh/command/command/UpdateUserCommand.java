package com.nnh.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateUserCommand {
	@TargetAggregateIdentifier
	private Long id;
	private String fullName;
	private String username;
	private String password;
	private Integer age;
	private String role;
	private String email;
	private Long phoneNum;
	private boolean isActive;
	
	public UpdateUserCommand(Builder builder) {
		this.fullName = builder.fullName;
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
		this.age = builder.age;
		this.phoneNum = builder.phoneNum;
		this.isActive = builder.isActive;
		this.role = builder.role;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
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
	
	public static class Builder {
		private Long id;
		private String fullName;
		private String username;
		private String password;
		private Integer age;
		private String email;
		private Long phoneNum;
		private boolean isActive;
		private String role;
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder fullName(String fullName) {
			this.fullName = fullName;
			return this;
		}
		
		public Builder userame(String username) {
			this.username = username;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder age(Integer age) {
			this.age = age;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder phoneNum(Long phoneNum) {
			this.phoneNum = phoneNum;
			return this;
		}
		
		public Builder isActive(boolean isActive) {
			this.isActive = isActive;
			return this;
		}
		
		public Builder roles(String role) {
			this.role = role;
			return this;
		}
		
		public UpdateUserCommand build() {
			return new UpdateUserCommand(this);
		}
	}
}
