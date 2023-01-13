package com.example.hopital.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 279829497505813609L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatient;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	public Patient(Long idPatient, String prenom, String nom) {
		super();
		this.idPatient = idPatient;
		this.prenom = prenom;
		this.nom = nom;
	}
	public Patient() {
		super();
	}
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
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
