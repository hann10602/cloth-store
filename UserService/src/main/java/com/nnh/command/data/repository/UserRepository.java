package com.nnh.command.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.command.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
