package com.zee.zee5.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Episode;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.EpisodeRepository;
import com.zee.zee5.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	EpisodeRepository episodeRepository;
	
	@Override
	public String addEpisode(Episode episode) throws IdNotFound {
		// TODO Auto-generated method stub
		Episode episode2=episodeRepository.save(episode);
		if(episode2!=null)
			return "success";
		return "fail";
	}

	@Override
	public String updateEpisodeById(String id, Episode episode) throws IdNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEpisodeById(String id) throws IdNotFound, InvalidIdLengthException,InvalidNameException {
		// TODO Auto-generated method stub
		Optional<Episode> optional;
		try {
			optional = this.getEpisodeById(id);
			if(optional.isEmpty()) {
				throw new IdNotFound("record not found");
			}
			else {
				episodeRepository.deleteById(id);
				return "register record deleted";
			}
		} catch (IdNotFound | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFound(e.getMessage());
		}
	}

	@Override
	public Optional<Episode> getEpisodeById(String id) throws IdNotFound, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return episodeRepository.findById(id);
	}

	@Override
	public Optional<List<Episode>> getAllEpisode() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodeRepository.findAll());
	}

	

}
