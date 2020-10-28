package com.springmvc.service;

import com.springmvc.dto.RoleDTO;

public interface IRoleService {
	RoleDTO findOne(Long id);
}
