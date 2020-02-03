package com.application.entites;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private long telephone;
	private long idCCMS;
	private String matricule;
	
	@NotNull
	private String role;
	
	@NotNull
	private String centre;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public long getIdCCMS() {
		return idCCMS;
	}
	public void setIdCCMS(long idCCMS) {
		this.idCCMS = idCCMS;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCentre() {
		return centre;
	}
	public void setCentre(String centre) {
		this.centre = centre;
	}
	public User(String id, String login, String password, String nom, String prenom, long telephone, long idCCMS,
			String matricule, String role, String centre) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.idCCMS = idCCMS;
		this.matricule = matricule;
		this.role = role;
		this.centre = centre;
	}
	public User() {
		super();
	}
	
	

	
}
