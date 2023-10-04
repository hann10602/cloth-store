package com.nnh.command.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class UserEntity implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String username;
	private String password;
	private Integer age;
	private String email;
	private Long phoneNum;
	private boolean isActive;
	private String role;
	
	public UserEntity() {
		super();
	}

	public UserEntity(Builder builder) {
		this.id = builder.id;
		this.fullName = builder.fullName;
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
		this.age = builder.age;
		this.phoneNum = builder.phoneNum;
		this.isActive = builder.isActive;
		this.role = builder.role;
	}

	public List<GrantedAuthority> convertRoles(String originRole) {
		List<GrantedAuthority> convertRoles = new ArrayList<>();
		convertRoles.add(new SimpleGrantedAuthority(originRole));
		
		return convertRoles;
	}
	
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isActive;
	}
	
	public static class Builder {
		private Long id = null;
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
		
		public Builder role(String role) {
			this.role = role;
			return this;
		}
		
		public UserEntity build() {
			return new UserEntity(this);
		}
	}
}
