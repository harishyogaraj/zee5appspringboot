package com.zee.zee5.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Series;
import com.zee.zee5.exeption.IdNotFound;

public interface SeriesRepository {

	public String addSeries(Series series);
	public String updateSeries(String id, Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFound;
	public Optional<List<Series>> getAllSeries();
	public String deleteSeriesById(String id) throws IdNotFound;
	
}
