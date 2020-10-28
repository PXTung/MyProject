package com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.entity.RoleEntity;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByCode(String code); 
}
