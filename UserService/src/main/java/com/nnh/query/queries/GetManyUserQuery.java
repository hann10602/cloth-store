package com.nnh.query.queries;

import org.springframework.data.domain.Pageable;

public class GetManyUserQuery {
	private Pageable pagable;

	public GetManyUserQuery(Pageable pagable) {
		super();
		this.pagable = pagable;
	}

	public Pageable getPagable() {
		return pagable;
	}

	public void setPagable(Pageable pagable) {
		this.pagable = pagable;
	}
	
	
}
