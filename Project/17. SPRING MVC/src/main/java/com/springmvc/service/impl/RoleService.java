package com.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.convert.RoleConvert;
import com.springmvc.dto.RoleDTO;
import com.springmvc.repository.IRoleRepository;
import com.springmvc.service.IRoleService;

@Service
public class RoleService implements IRoleService{

	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private RoleConvert roleConvert;
	
	@Override
	public RoleDTO findOne(Long id) {	
		return roleConvert.toDto(roleRepository.findOne(id));
	}

}
