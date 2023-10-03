package com.nnh.command.event;

public class UserDeletedEvent {
	private Long id;
	
	public UserDeletedEvent(Long id) {
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
