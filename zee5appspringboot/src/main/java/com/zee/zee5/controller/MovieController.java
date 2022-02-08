//package com.zee.zee5.controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.zee.zee5.dto.Movie;
//import com.zee.zee5.dto.Register;
//import com.zee.zee5.exeption.AlreadyExistsException;
//import com.zee.zee5.service.MovieService;
//import com.zee.zee5.service.UserService;
//
//@RestController
//@RequestMapping("/movie")
//public class MovieController {
//
//	@Autowired
//	MovieService movieService;
//	
//	//Transforming json into java object ==> @RequestBody
//	@PostMapping("/addMovies")
//	public ResponseEntity<?> addMovies(@RequestBody Movie movie)
//	{
//	
//		Movie result=	movieService.addMovie(movie);
//		System.out.println(result);
//		return ResponseEntity.status(201).body(result);
//		 
////		catch (AlreadyExistsException e) {
////			// TODO Auto-generated catch block
////			Map<String, String> hashMap =new HashMap<>();
////			hashMap.put("message", "record already exists");
////			return ResponseEntity.badRequest().body(hashMap);
////		}
//	//	return register.toString();
//	}
//}
