package com.nnh.command.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.command.model.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findOneByCode(String code);
}
