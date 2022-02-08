package com.zee.zee5.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.AlreadyExistsException;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.service.UserService;


@RestController  // @ResponseBody @Controller

//whenever we have to share the response that method must be marked with @ResponseBody
//1000 methods --> 1000 @Repository -->so merge @Controller
@RequestMapping("/users")

public class UserController {

	@Autowired
	UserService userService;
	
	//Transforming json into java object ==> @RequestBody
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Register register) throws AlreadyExistsException
	{
	//	try {
		Register result=	userService.addUser(register);
		System.out.println(result);
		return ResponseEntity.status(201).body(result);
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			Map<String, String> hashMap =new HashMap<>();
//			hashMap.put("message", "record already exists");
//			return ResponseEntity.badRequest().body(hashMap);
//		}
	//	return register.toString();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@Valid@PathVariable("id") String id) throws IdNotFound
	{
		Register register= userService.getUserById(id);
		return ResponseEntity.ok(register);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers()
	{
		Optional<List<Register>> optional= userService.getAllRegisters();
		
		if(optional.isEmpty())
		{
			Map<String,String> map=new HashMap<>();
			map.put("message", "no records found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
	
}
