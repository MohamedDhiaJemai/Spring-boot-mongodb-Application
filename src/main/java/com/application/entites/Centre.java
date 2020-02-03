package com.application.entites;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Centre {

	@Id
	private String id;
	private String reference;
	private String libelle;

	@DBRef
	private Collection<User> users = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Centre() {
		super();
	}

	public Centre(String id, String reference, String libelle, Collection<User> users) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
		this.users = users;
	}

}
