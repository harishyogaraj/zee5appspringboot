package com.zee.zee5.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, String> {

	//custom jpa method. there is no defin just signature/declaration
	
	boolean existsByEmailAndContactNumber(String email,BigDecimal contactNumber);
//	boolean existsByContactNumber(BigDecimal contactNumber);
}
