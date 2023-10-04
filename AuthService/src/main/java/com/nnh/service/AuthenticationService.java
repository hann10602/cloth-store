package com.nnh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnh.command.model.dto.UserRequestDTO;
import com.nnh.command.model.entity.UserEntity;
import com.nnh.data.repository.RoleRepository;
import com.nnh.data.repository.TokenRepository;
import com.nnh.model.authentication.TokenResponse;
import com.nnh.model.entity.TokenEntity;

@Service
public class AuthenticationService {
	private final RoleRepository roleRep;
	private final TokenRepository tokenRep;
	private final JwtService jwtService;
	final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthenticationService(RoleRepository roleRep, TokenRepository tokenRep, JwtService jwtService,
			AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
		super();
		this.roleRep = roleRep;
		this.tokenRep = tokenRep;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
	}
	
	public TokenResponse register(UserRequestDTO request) {
		UserEntity user = new UserEntity.Builder()
				.fullName(request.getFullName())
				.userame(request.getUsername())
				.password(request.getPassword())
				.age(request.getAge())
				.phoneNum(request.getPhoneNum())
				.email(request.getEmail())
				.isActive(true)
				.role(passwordEncoder.encode(request.getPassword()))
				.build();
	    
	    String jwtToken = jwtService.generateToken(user);
	    
	    TokenEntity token = new TokenEntity.Builder()
	    		.token(jwtToken)
	    		.username(request.getUsername())
	    		.password(request.getPassword())
	    		.build();
	    
	    tokenRep.save(token);
	    
	    return new TokenResponse(jwtToken);
	}
}
