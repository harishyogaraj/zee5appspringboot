package com.zee.zee5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
