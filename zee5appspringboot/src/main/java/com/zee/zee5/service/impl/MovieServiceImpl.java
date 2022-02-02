package com.zee.zee5.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.MovieRepository;
import com.zee.zee5.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieService;
	
	public MovieServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie movie1 =movieService.save(movie);
		if(movie1==null)
			return "fail";
		return "success";
	}

	@Override
	public String updateMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		return movieService.findById(id);
	}

	@Override
	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieService.findAll());
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		try {
			Optional<Movie> optional = this.getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFound("record not found");
			}
			else {
				movieService.deleteById(id);
			return "success";}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFound(e.getMessage());
		}
	}
	
//	@Override
//	public String addMovie(Movie movie) {
//		// TODO Auto-generated method stub
//		
//		
//		return movieService.addMovie(movie);
//	}
//
//	@Override
//	public String updateMovie(String id, Movie movie) {
//		// TODO Auto-generated method stub
//		return movieService.updateMovie(id, movie);
//	}
//
//	@Override
//	public Optional<Movie> getMovieById(String id) throws IdNotFound {
//		// TODO Auto-generated method stub
//		return movieService.getMovieById(id);
//	}
//
//	@Override
//	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException, InvalidNameException {
//		// TODO Auto-generated method stub
//		return movieService.getAllMovies();
//	}
//
//	@Override
//	public String deleteMovieById(String id) throws IdNotFound {
//		// TODO Auto-generated method stub
//		return movieService.deleteMovieById(id);
//	}

}
