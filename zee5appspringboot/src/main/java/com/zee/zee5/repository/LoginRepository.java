package com.zee.zee5.repository;

import javax.management.relation.Role;

import com.zee.zee5.dto.Login;
import com.zee.zee5.dto.ROLE;

public interface LoginRepository {

	public String addCredentials(Login login);

	public String deleteCredentials(String userName);

	public String changePassword(String userName,String password);

	public String changeRole(String userName,ROLE role);
}
