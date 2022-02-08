package com.zee.zee5.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

	boolean existsByMovieName(String movieName);
	Optional<Movie> findByMovieNameAndLanguage(String movieName,String language);
	
	Optional<Movie> findByMovieNameAndReleasedate(String movieName,Date releasedate);
	Optional<List<Movie>> findByCast(String cast);
}
