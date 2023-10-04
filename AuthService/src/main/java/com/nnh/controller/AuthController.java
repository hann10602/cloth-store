package com.nnh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.command.model.dto.UserRequestDTO;
import com.nnh.model.authentication.TokenResponse;
import com.nnh.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<TokenResponse> register(@RequestBody UserRequestDTO request) {
		return ResponseEntity.ok(service.register(request));
	}
}
