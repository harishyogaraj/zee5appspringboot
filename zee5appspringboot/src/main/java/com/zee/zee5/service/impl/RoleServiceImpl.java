package com.zee.zee5.service.impl;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Role;
import com.zee.zee5.repository.RoleRepository;
import com.zee.zee5.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role role2=roleRepository.save(role);
		if(role2!=null)
			return "success";
		else
			return "fail";
	}

	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub

	}

}
