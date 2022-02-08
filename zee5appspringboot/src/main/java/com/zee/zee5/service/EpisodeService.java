package com.zee.zee5.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Episode;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;

import java.util.List;

@Service
public interface EpisodeService {
	public String addEpisode(Episode episode) throws IdNotFound;

	public String updateEpisodeById(String id, Episode episode) throws IdNotFound;

	public String deleteEpisodeById(String id) throws IdNotFound, InvalidIdLengthException, InvalidNameException;

	public Optional<Episode> getEpisodeById(String id) throws IdNotFound, InvalidIdLengthException;

	public Optional<List<Episode>> getAllEpisode() throws InvalidIdLengthException;
	
}
