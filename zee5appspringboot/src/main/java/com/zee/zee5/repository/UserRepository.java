package com.zee.zee5.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;

public interface UserRepository {

	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id) throws IdNotFound, InvalidNameException, InvalidIdLengthException;
	public Optional<List<Register>> getAllRegisters() throws InvalidIdLengthException, InvalidNameException;
	public String deleteUserById(String id) throws IdNotFound;
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException;
	
	
}
