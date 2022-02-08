package com.zee.zee5.service;


import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Login;
import com.zee.zee5.dto.Role;

@Service
public interface LoginService {

	public String addCredentials(Login login);

	public String deleteCredentials(String userName);

	public String changePassword(String userName,String password);


	public String changeRole(String userName,Role role);



}
