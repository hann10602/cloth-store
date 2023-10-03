package com.nnh.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.query.model.dto.UserResponseDTO;
import com.nnh.query.queries.GetAllUserQuery;
import com.nnh.query.queries.GetManyUserQuery;
import com.nnh.query.queries.GetUserQuery;

@RestController
@RequestMapping("/api/v1/user/query")
public class UserQueryController {
	private final QueryGateway queryGateway;
	
	@Autowired
	public UserQueryController(QueryGateway queryGateway) {
		super();
		this.queryGateway = queryGateway;
	}
	
	@GetMapping("/get/{userId}")
	public UserResponseDTO getUser(@PathVariable Long userId) {
		GetUserQuery query = new GetUserQuery(userId);
		
		UserResponseDTO dto = queryGateway.query(query, ResponseTypes.instanceOf(UserResponseDTO.class)).join();
		
		return dto;
	}
	
	@GetMapping("/get-many")
	public List<UserResponseDTO> getManyUser(@RequestParam("p") Pageable pageable) {
		GetManyUserQuery query = new GetManyUserQuery(pageable);
		
		List<UserResponseDTO> dtoList = queryGateway.query(query, ResponseTypes.multipleInstancesOf(UserResponseDTO.class)).join();
		
		return dtoList;
	}
	
	@GetMapping("/get-all")
	public List<UserResponseDTO> getAllUser() {
		GetAllUserQuery query = new GetAllUserQuery();
		
		List<UserResponseDTO> dtoList = queryGateway.query(query, ResponseTypes.multipleInstancesOf(UserResponseDTO.class)).join();
		
		return dtoList;
	}
}
