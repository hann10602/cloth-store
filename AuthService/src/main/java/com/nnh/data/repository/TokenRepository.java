package com.nnh.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnh.model.entity.TokenEntity;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long>{
	TokenEntity findOneByUsername(String username);
}
