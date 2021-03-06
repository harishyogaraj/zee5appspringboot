package com.zee.zee5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

	boolean existsByUsername(String username);
}
