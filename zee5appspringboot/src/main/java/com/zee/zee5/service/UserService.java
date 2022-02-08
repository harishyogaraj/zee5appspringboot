package com.zee.zee5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.AlreadyExistsException;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;

@Service
public interface UserService {

	public Register addUser(Register register) throws AlreadyExistsException;
	public String updateUser(String id, Register register);
	public Register getUserById(String id) throws IdNotFound;
	public Optional<List<Register>> getAllRegisters();
	public String deleteUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException;
	public Register[] getAllUsers();
}
