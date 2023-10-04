package com.nnh.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nnh.command.data.repository.UserRepository;
import com.nnh.command.model.entity.UserEntity;
import com.nnh.query.model.dto.UserResponseDTO;
import com.nnh.query.queries.GetAllUserQuery;
import com.nnh.query.queries.GetManyUserQuery;
import com.nnh.query.queries.GetUserQuery;

@Component
public class UserProjection {
	private final UserRepository userRep;
	
	@Autowired
	public UserProjection(UserRepository userRep) {
		this.userRep = userRep;
	}
	
	@QueryHandler
	public UserResponseDTO getUser(GetUserQuery query) {
		UserEntity entity = userRep.getById(query.getId());
		
		UserResponseDTO dto = new UserResponseDTO.Builder()
				.fullName(entity.getFullName())
				.userame(entity.getUsername())
				.password(entity.getPassword())
				.age(entity.getAge())
				.phoneNum(entity.getPhoneNum())
				.email(entity.getEmail())
				.isActive(entity.isActive())
				.role(entity.getRole())
				.build();
		
		return dto;
	}
	
	@QueryHandler
	public List<UserResponseDTO> getManyUser(GetManyUserQuery query) {
		Page<UserEntity> page = userRep.findAll(query.getPagable());
		List<UserEntity> entityList = page.getContent();
		
		List<UserResponseDTO> dtoList = new ArrayList<>();
		
		for(UserEntity entity : entityList) {
			dtoList.add(new UserResponseDTO.Builder()
				.fullName(entity.getFullName())
				.userame(entity.getUsername())
				.password(entity.getPassword())
				.age(entity.getAge())
				.phoneNum(entity.getPhoneNum())
				.email(entity.getEmail())
				.isActive(entity.isActive())
				.role(entity.getRole())
				.build());
		}
		
		return dtoList;
	}
	
	@QueryHandler
	public List<UserResponseDTO> getAllUser(GetAllUserQuery query) {
		List<UserEntity> entityList = userRep.findAll();
		
		List<UserResponseDTO> dtoList = new ArrayList<>();
		
		for(UserEntity entity : entityList) {
			dtoList.add(new UserResponseDTO.Builder()
				.fullName(entity.getFullName())
				.userame(entity.getUsername())
				.password(entity.getPassword())
				.age(entity.getAge())
				.phoneNum(entity.getPhoneNum())
				.email(entity.getEmail())
				.isActive(entity.isActive())
				.role(entity.getRole())
				.build());
		}
		
		return dtoList;
	}
}
