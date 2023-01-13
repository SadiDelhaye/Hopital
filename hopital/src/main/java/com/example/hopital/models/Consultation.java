package com.example.hopital.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultation")
public class Consultation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9089281603962245703L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsultation;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_patient", referencedColumnName = "idPatient")
	private Docteur docteur;
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_patient", referencedColumnName = "idDocteur")
	private Patient patient;
	public Consultation(Long idConsultation, LocalDate date, Docteur docteur, Patient patient) {
		super();
		this.idConsultation = idConsultation;
		this.date = date;
		this.docteur = docteur;
		this.patient = patient;
	}
	public Consultation() {
		super();
	}
	public Long getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(Long idConsultation) {
		this.idConsultation = idConsultation;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Docteur getDocteur() {
		return docteur;
	}
	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
