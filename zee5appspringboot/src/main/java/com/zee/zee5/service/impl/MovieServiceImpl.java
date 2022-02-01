package com.zee.zee5.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.MovieRepository;
import com.zee.zee5.repository.impl.MovieRepositoryImpl;
import com.zee.zee5.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieRepository movieService;
	
	public MovieServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		
		
		return movieService.addMovie(movie);
	}

	@Override
	public String updateMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		return movieService.updateMovie(id, movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		return movieService.getMovieById(id);
	}

	@Override
	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return movieService.getAllMovies();
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		return movieService.deleteMovieById(id);
	}

}
