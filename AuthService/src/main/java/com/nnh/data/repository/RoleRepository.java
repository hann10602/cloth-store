package com.nnh.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnh.model.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findOneByCode(String code);
}
