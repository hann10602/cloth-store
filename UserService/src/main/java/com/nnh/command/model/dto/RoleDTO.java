package com.nnh.command.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import com.nnh.command.model.entity.UserEntity;

public class RoleDTO {
	private Long id;
	private String name;
	private String code;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
