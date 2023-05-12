package com.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authentication.models.Role;
import com.authentication.models.User;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
	
	public Role findByName(String name);
	
}
