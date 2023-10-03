package com.nnh.query.model.dto;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {
	private Long id;
	private String fullName;
	private String username;
	private String password;
	private Integer age;
	private String email;
	private Long phoneNum;
	private boolean isActive;
	private String role;
	private String sortBy;
	private Integer fPage;
	private Integer lPage;
	private Integer tPage;
	private List<UserResponseDTO> userList;
	
	
	public UserResponseDTO(Builder builder) {
		this.id = builder.id;
		this.fullName = builder.fullName;
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
		this.age = builder.age;
		this.phoneNum = builder.phoneNum;
		this.isActive = builder.isActive;
		this.role = builder.role;
		this.sortBy = builder.sortBy;
		this.fPage = builder.fPage;
		this.lPage = builder.lPage;
		this.tPage = builder.tPage;
		this.userList = builder.userList;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public Integer getfPage() {
		return fPage;
	}
	public void setfPage(Integer fPage) {
		this.fPage = fPage;
	}
	public Integer getlPage() {
		return lPage;
	}
	public void setlPage(Integer lPage) {
		this.lPage = lPage;
	}
	public Integer gettPage() {
		return tPage;
	}
	public void settPage(Integer tPage) {
		this.tPage = tPage;
	}
	public List<UserResponseDTO> getUserList() {
		return userList;
	}
	public void setUserList(List<UserResponseDTO> userList) {
		this.userList = userList;
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
		private String sortBy = null;
		private Integer fPage = null;
		private Integer lPage = null;
		private Integer tPage = null;
		private List<UserResponseDTO> userList = new ArrayList<>();
		
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
		
		public Builder role(String role) {
			this.role = role;
			return this;
		}
		
		public Builder sortBy(String sortBy) {
			this.sortBy = sortBy;
			return this;
		}
		
		public Builder fPage(Integer fPage) {
			this.fPage = fPage;
			return this;
		}
		
		public Builder lPage(Integer lPage) {
			this.lPage = lPage;
			return this;
		}
		
		public Builder tPage(Integer tPage) {
			this.tPage = tPage;
			return this;
		}
		
		public Builder userList(List<UserResponseDTO> userList) {
			this.userList = userList;
			return this;
		}
		
		public UserResponseDTO build() {
			return new UserResponseDTO(this);
		}
	}
}
