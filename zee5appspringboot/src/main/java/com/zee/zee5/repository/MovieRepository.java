package com.zee.zee5.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;

public interface MovieRepository {

	public String addMovie(Movie movie);
	public String updateMovie(String id, Movie movie);
	public Optional<Movie> getMovieById(String id) throws IdNotFound;
	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException, InvalidNameException;
	public String deleteMovieById(String id) throws IdNotFound;
	
	
}
