package com.zee.zee5.service.impl;

import java.io.IOException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Login;
import com.zee.zee5.dto.Role;
import com.zee.zee5.repository.LoginRepository;
import com.zee.zee5.service.LoginService;
import com.zee.zee5.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	
	public LoginServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
		// loginRepository=LoginRepositoryImpl.getInstance();
	}
	
	
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		System.out.println(login);
		Login login2=loginRepository.save(login);
		System.out.println(login2);
		if(login2!=null)
			return "success";
		return "fail";
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
	//	return loginRepository.deleteCredentials(userName);
		return null;
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
	//	return loginRepository.changePassword(userName, password);
		return null;
	}



	@Override
	public String changeRole(String userName, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	

		
	

	

	}
