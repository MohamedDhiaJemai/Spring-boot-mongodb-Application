package com.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.entites.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);

	Role findByDescription(String description);

}
