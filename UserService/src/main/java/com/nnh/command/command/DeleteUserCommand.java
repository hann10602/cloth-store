package com.nnh.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteUserCommand {
	@TargetAggregateIdentifier
	private Long id;
	
	public DeleteUserCommand(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
