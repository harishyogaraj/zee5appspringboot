package com.zee.zee5.controlleradvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5.exeption.AlreadyExistsException;
import com.zee.zee5.exeption.IdNotFound;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsExceptionHandler()
	{
		HashMap<String, String> map=new HashMap<>();
		map.put("message", "Record already exists");
		return ResponseEntity.badRequest().body(map);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> ExceptionHandler(Exception e)
//	{
//		HashMap<String, String> map=new HashMap<>();
//		map.put("message", "Unkown Exception "+e.getMessage());
//		return ResponseEntity.badRequest().body(map);
//	}
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(IdNotFound e)
	{
		HashMap<String, String> map=new HashMap<>();
		map.put("message", "Unkown Exception "+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
}
