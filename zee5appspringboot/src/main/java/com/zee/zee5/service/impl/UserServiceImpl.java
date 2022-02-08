package com.zee.zee5.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Login;
import com.zee.zee5.dto.EROLE;
import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.AlreadyExistsException;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.LoginRepository;
import com.zee.zee5.repository.UserRepository;
import com.zee.zee5.service.LoginService;
//import com.zee.zee5.repository.impl.UserRepositoryImpl;
import com.zee.zee5.service.UserService;
import com.zee.zee5.utils.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	PasswordUtils passwordUtils;

	
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
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		
		
		Register register2 = userRepository.save(register);
		
		 if(register2!=null)
		 { 
	//		 System.out.println(register2);
			 Login login = new Login();
				login.setUsername(register.getEmail());
				login.setPassword(register.getPassword());
				login.setRegister(register2);
	//			login.setRoleId(EROLE.ROLE_USER);
				if(loginRepository.existsByUsername(register.getEmail()))
				{
					throw new AlreadyExistsException("this record already existed");
				}
				
			 String res=loginService.addCredentials(login);
			 if(res.equals("success"))
				 return register;
			 else
				 return null;
		 }
		 else
			 return null;
		
	}

@Override
public String updateUser(String id, Register register) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Register getUserById(String id) throws IdNotFound {
	// TODO Auto-generated method stub
	Optional<Register> optional=userRepository.findById(id);
	if(optional.isEmpty())
		throw new IdNotFound("id doesnot exists");
	else
		return optional.get();
	

}

@Override
public Optional<List<Register>> getAllRegisters() {
	// TODO Auto-generated method stub
	return Optional.ofNullable(userRepository.findAll());
}

@Override
public String deleteUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException {
	// TODO Auto-generated method stub
	Register optional;
	try {
		 optional = this.getUserById(id);
		if(optional==null) {
			throw new IdNotFound("record not found");
		}
		else {
			userRepository.deleteById(id);
		return "success";
		}
	} catch (IdNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new IdNotFound(e.getMessage());
	}
	
}

@Override
public Register[] getAllUsers() {
	// TODO Auto-generated method stub
	List<Register> list =userRepository.findAll();
	Register[] array=new Register[list.size()];
	return list.toArray(array);
			
}

//	@Override
//	public String updateUser(String id, Register register) {
//		// TODO Auto-generated method stub
//		return userRepository.updateUser(id, register);
//	}
//
//	@Override
//	public Optional<Register> getUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		
//		return userRepository.getUserById(id);
//	}
//
////	@Override
////	public Register[] getAllUseRegisters() {
////		// TODO Auto-generated method stub
////		return userRepository.getAllRegisters();
////	}
//
//	@Override
//	public String deleteUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		return userRepository.deleteUserById(id);
////		try {
////			Optional<Register> optional=this.getUserById(id);
////		} catch (IdNotFound e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return null;
//	}
//
//
//@Override
//public Optional<List<Register>> getAllRegisters() throws InvalidIdLengthException, InvalidNameException {
//	// TODO Auto-generated method stub
//	return userRepository.getAllRegisters();
//}
//
//
//@Override
//public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
//	// TODO Auto-generated method stub
//	return userRepository.getAllUsers();
//}

}
