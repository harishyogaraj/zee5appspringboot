package com.zee.zee5.service;

import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Role;

@Service
public interface RoleService {

	public String addRole(Role role);
	public void deleteRole(int roleId);

}
