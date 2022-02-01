package com.zee.zee5.repository.impl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.management.loading.PrivateClassLoader;
import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5.config.Config;
import com.zee.zee5.dto.Login;
import com.zee.zee5.dto.ROLE;
import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.LoginRepository;
import com.zee.zee5.repository.UserRepository;
import com.zee.zee5.utils.PasswordUtils;

//@Component, @service, @bean --->work same->give singleton object.
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	DataSource dataSource;
	
	
//	static private DBUtils dbUtils = null;
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	PasswordUtils passwordUtils;
	
	
	public UserRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	//	loginRepository=LoginRepositoryImpl.getInstance();
	
		//dbUtils=DBUtils.getInstance();
	}
	
//	private static UserRepository repository;
//	public static UserRepository getInstance() throws IOException {
//		if(repository==null)
//		{
//			repository=new UserRepositoryImpl();
//		}
//		return repository;
//	}
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub

		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "insert into register" + "(regid,firstname,lastname,email,contactnumber,password)"
				+ " values(?,?,?,?,?,?)";

		try {
			connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(insertStatement);

			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());

			String salt = passwordUtils.getSalt(30);
			String encryptedPassword = passwordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedStatement.setString(6, encryptedPassword);

			int result = preparedStatement.executeUpdate();
		//	connection.commit();
			if (result > 0) {
	//			connection.commit();
				Login login = new Login();
				login.setUsername(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegId(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String result2 = loginRepository.addCredentials(login);
				if (result2.equals("success")) {
					return "success";
				} else {
					connection.rollback();
					return "fail";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
						e.printStackTrace();
		}
		return "faili";
	}		

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		//Updating contact number.
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String statement="update register set contactnumber=? where regid=?";
		try {
			connection=dataSource.getConnection();

			preparedStatement=connection.prepareStatement(statement);
			preparedStatement.setString(2, id);
			preparedStatement.setBigDecimal(1, register.getContactNumber());
			
			int result=preparedStatement.executeUpdate();
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
		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		
	}
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String selectStatement="select * from register where regId=?";
		
		try {
			connection=dataSource.getConnection();

			preparedStatement=connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				Register register=new Register();
							
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setemail(resultSet.getString("email"));
				register.setpassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));

				return Optional.of((register));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return Optional.empty();			
	}
	
	@Override
	public Optional<List<Register>> getAllRegisters() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		ArrayList<Register> arrayList=new ArrayList<Register>();
		String selectStatement="select * from register";
		
		try {
			connection=dataSource.getConnection();

			preparedStatement=connection.prepareStatement(selectStatement);
		
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Register register=new Register();
							
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setemail(resultSet.getString("email"));
				register.setpassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				arrayList.add(register);
				
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
				
		return Optional.empty();
	
		
	
	}
	@Override
	public String deleteUserById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String deleteStatement="delete from register where regid=?";
		
		try {
			connection=dataSource.getConnection();

			preparedStatement=connection.prepareStatement(deleteStatement);
			
			preparedStatement.setString(1, id);
			
			int result=preparedStatement.executeUpdate();
			
			if(result>0)
			{
				
								
				return "success";
			}
			else
				return "failure";
						
		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
		
		
	
	}
	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional=getAllRegisters();
		
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			List<Register> list=optional.get();
			Register[] registers=new Register[list.size()];
			return list.toArray(registers);
		}
	
	}

	
	

}
