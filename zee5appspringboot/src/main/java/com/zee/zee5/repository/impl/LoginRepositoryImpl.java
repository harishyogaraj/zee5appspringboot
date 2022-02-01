package com.zee.zee5.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.relation.Role;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Login;
import com.zee.zee5.dto.ROLE;
import com.zee.zee5.repository.LoginRepository;
import com.zee.zee5.utils.PasswordUtils;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	
	//DBUtils dbUtils =DBUtils.getInstance();

	@Autowired
	DataSource dataSource;


	
	public LoginRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
//	private static LoginRepository repository;
//	public static LoginRepository getInstance() throws IOException {
//		if(repository==null)
//		{
//			repository=new LoginRepositoryImpl();
//		}
//		return repository;
//	}
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		String insertQuery = "insert into login (username, password, regId,role)" + "values(?,?,?,?)";
		Connection connection=null;
		try {
			connection = dataSource.getConnection();

			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
			prepStatement.setString(1, login.getUsername());
			prepStatement.setString(2, login.getPassword());
			prepStatement.setString(3, login.getRegId());
			prepStatement.setString(4, login.getRole().toString());

			int result = prepStatement.executeUpdate();
			if (result > 0) {
		//		connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} 
		
		
	
}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String updateStatement="UPDATE login SET role=? where username=?";

		try {
			connection=dataSource.getConnection();

			preparedStatement=connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());

			preparedStatement.setString(2, userName);
			
			int result = preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "faili?";
		}
			}
	
	
}
