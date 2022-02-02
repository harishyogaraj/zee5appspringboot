package com.zee.zee5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, String> {

}
