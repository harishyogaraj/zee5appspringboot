package com.zee.zee5.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.UserRepository;
import com.zee.zee5.repository.impl.UserRepositoryImpl;
import com.zee.zee5.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	//=UserRepositoryImpl.getInstance();
	public UserServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
//	private static UserService service;
//	
//	public static UserService getInstance() throws IOException
//	{
//		if(service==null)
//		{
//			service=new UserServiceImpl();
//			
//		}
//		return service;
//	}
	
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		
		return userRepository.getUserById(id);
	}

//	@Override
//	public Register[] getAllUseRegisters() {
//		// TODO Auto-generated method stub
//		return userRepository.getAllRegisters();
//	}

	@Override
	public String deleteUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
//		try {
//			Optional<Register> optional=this.getUserById(id);
//		} catch (IdNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
	}


@Override
public Optional<List<Register>> getAllRegisters() throws InvalidIdLengthException, InvalidNameException {
	// TODO Auto-generated method stub
	return userRepository.getAllRegisters();
}


@Override
public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
	// TODO Auto-generated method stub
	return userRepository.getAllUsers();
}

}
