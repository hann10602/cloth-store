package com.nnh.command.event;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnh.command.data.repository.UserRepository;
import com.nnh.command.model.entity.RoleEntity;
import com.nnh.command.model.entity.UserEntity;

@Component
public class UserEventHandler {
	private final UserRepository userRep;
	
	@Autowired
	public UserEventHandler(UserRepository userRep) {
		super();
		this.userRep = userRep;
	}
	
	@EventHandler
	public void createUser(UserCreatedEvent event) {
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(event.getRole());
		
		UserEntity user = new UserEntity.Builder()
				.fullName(event.getFullName())
				.userame(event.getUsername())
				.password(event.getPassword())
				.age(event.getAge())
				.phoneNum(event.getPhoneNum())
				.email(event.getEmail())
				.isActive(event.isActive())
				.roles(roles)
				.build();
		
		userRep.save(user);
	}
	
	@EventHandler
	public void updateUser(UserUpdatedEvent event) {
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(event.getRole());
		
		UserEntity user = new UserEntity.Builder()
				.id(event.getId())
				.fullName(event.getFullName())
				.userame(event.getUsername())
				.password(event.getPassword())
				.age(event.getAge())
				.phoneNum(event.getPhoneNum())
				.email(event.getEmail())
				.isActive(event.isActive())
				.roles(roles)
				.build();;
		
		userRep.save(user);
	}
	
	@EventHandler
	public void deleteUser(UserDeletedEvent event) {
		userRep.deleteById(event.getId());
	}
}
