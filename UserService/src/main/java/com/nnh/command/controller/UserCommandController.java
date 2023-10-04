package com.nnh.command.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.command.command.CreateUserCommand;
import com.nnh.command.model.dto.UserRequestDTO;

@RestController
@RequestMapping("/api/v1/user/command")
public class UserCommandController {
	private final CommandGateway commandGateway;
	
	@Autowired
	public UserCommandController(CommandGateway commandGateway) {
		super();
		this.commandGateway = commandGateway;
	}
	
	@PostMapping("/add")
	public String registerUser(@RequestBody UserRequestDTO dto) {
		try {
			CreateUserCommand command = new CreateUserCommand.Builder()
					.fullName(dto.getFullName())
					.userame(dto.getUsername())
					.password(dto.getPassword())
					.age(dto.getAge())
					.phoneNum(dto.getPhoneNum())
					.email(dto.getEmail())
					.isActive(dto.isActive())
					.role(dto.getRole())
					.build();
			
			commandGateway.sendAndWait(command);
			
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			
			return "Fail";
		}
	}
}
