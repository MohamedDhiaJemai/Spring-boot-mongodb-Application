package com.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.entites.Centre;

public interface CentreRepository extends MongoRepository<Centre, String> {

	Centre findByReference(String reference);

	Centre findByLibelle(String libelle);

}