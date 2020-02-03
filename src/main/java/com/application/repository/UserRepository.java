package com.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.entites.User;

public interface UserRepository extends MongoRepository<User, String> {

	/* User */
	List<User> findByNom(String nom);

	List<User> findByPrenom(String prenom);

	User findByLogin(String login);

	List<User> findByMatricule(String matricule);

	/* Centre */
	List<User> findByCentre(String idCentre);

//	List<User> findByCentreAndDeleted(String idCentre, boolean deleted);

	/* Role */
	List<User> findByRole(String idRole);

//	List<User> findByRoleAndDeleted(String idRole, boolean deleted);

}
