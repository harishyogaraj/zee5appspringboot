package com.zee.zee5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.exeption.AlreadyExistsException;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;

@Service
public interface MovieService {

	public Movie addMovie(Movie movie) throws AlreadyExistsException;
	public String updateMovie(String id, Movie movie);
	public Optional<Movie> getMovieById(String id) throws IdNotFound;
	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException, InvalidNameException;
	public String deleteMovieById(String id) throws IdNotFound;
	
}
