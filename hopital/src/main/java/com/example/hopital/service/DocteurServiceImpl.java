package com.example.hopital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hopital.models.Docteur;
import com.example.hopital.DAO.DocteurDAO;

public class DocteurServiceImpl implements DocteurService{

	@Autowired
	private DocteurDAO docteurDAO;
	
	@Override
	public List<Docteur> getDocteurs() {
		List<Docteur> docteur = (List<Docteur>) docteurDAO.findAll();
		if(!docteur.isEmpty()) {
			return docteur;
		}
		else {
			return null;
		}
	}

	@Override
	public Docteur saveDocteur(Docteur docteur) {
		Docteur _docteur = new Docteur();
		_docteur.setPrenom(docteur.getPrenom());
		_docteur.setNom(docteur.getNom());
		docteurDAO.save(_docteur);
		return _docteur;
	}

	@Override
	public Docteur getDocteurByID(Long id) {
		Optional<Docteur> retrievedDocteur = docteurDAO.findById(id);
		if(retrievedDocteur.isPresent()) {
			return retrievedDocteur.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Docteur updateDocteur(Long id, Docteur docteur) {
		Optional<Docteur> retrievedDocteur = docteurDAO.findById(id);
		Docteur _doctor = retrievedDocteur.get();
		_doctor.setPrenom(docteur.getPrenom());
		_doctor.setNom(docteur.getNom());
		docteurDAO.save(_doctor);
		return _doctor;
	}

	@Override
	public void deleteByID(Long id) {
		docteurDAO.deleteById(id);
		
	}

	@Override
	public void deleteDocteurs() {
		docteurDAO.deleteAll();		
	}

}
