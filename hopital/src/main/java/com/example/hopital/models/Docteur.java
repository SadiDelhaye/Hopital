package com.example.hopital.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "docteur")
public class Docteur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1476857132632297201L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocteur;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	public Docteur(Long idDocteur, String prenom, String nom) {
		super();
		this.idDocteur = idDocteur;
		this.prenom = prenom;
		this.nom = nom;
	}
	public Docteur() {
		super();
	}
	public Long getIdDocteur() {
		return idDocteur;
	}
	public void setIdDocteur(Long idDocteur) {
		this.idDocteur = idDocteur;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
}
