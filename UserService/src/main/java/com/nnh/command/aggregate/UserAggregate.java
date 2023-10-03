package com.nnh.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.nnh.command.command.CreateUserCommand;
import com.nnh.command.command.DeleteUserCommand;
import com.nnh.command.command.UpdateUserCommand;
import com.nnh.command.event.UserCreatedEvent;
import com.nnh.command.event.UserDeletedEvent;
import com.nnh.command.event.UserUpdatedEvent;
import com.nnh.command.model.entity.RoleEntity;

@Aggregate
public class UserAggregate {
	@AggregateIdentifier
	private Long id;
	private String fullName;
	private String username;
	private String password;
	private RoleEntity role;
	private String email;
	private Long phoneNum;
	private boolean isActive;
	
	@CommandHandler
	public UserAggregate(CreateUserCommand command) {
		UserCreatedEvent event = new UserCreatedEvent(command.getFullName(), command.getUsername(), command.getPassword(), command.getRole(), command.getEmail(), command.getPhoneNum(), command.isActive());
	
		AggregateLifecycle.apply(event);
	}
	
	@CommandHandler
	public void handler(UpdateUserCommand command) {
		UserUpdatedEvent event = new UserUpdatedEvent(command.getId(), command.getFullName(), command.getUsername(), command.getPassword(), command.getRole(), command.getEmail(), command.getPhoneNum(), command.isActive());
		
		AggregateLifecycle.apply(event);
	}
	
	@CommandHandler
	public void handler(DeleteUserCommand command) {
		UserDeletedEvent event = new UserDeletedEvent(command.getId());
		
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(UserCreatedEvent event) {
		this.fullName = event.getFullName();
		this.username = event.getUsername();
		this.password = event.getPassword();
		this.role = event.getRole();
		this.email = event.getEmail();
		this.phoneNum = event.getPhoneNum();
		this.isActive = event.isActive();
	}
	
	@EventSourcingHandler
	public void on(UserUpdatedEvent event) {
		this.id = event.getId();
		this.fullName = event.getFullName();
		this.username = event.getUsername();
		this.password = event.getPassword();
		this.role = event.getRole();
		this.email = event.getEmail();
		this.phoneNum = event.getPhoneNum();
		this.isActive = event.isActive();
	}
	
	@EventSourcingHandler
	public void on(UserDeletedEvent event) {
		this.id = event.getId();
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
