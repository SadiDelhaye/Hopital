package com.example.hopital.service;

import java.util.List;

import com.example.hopital.models.Docteur;

public interface DocteurService {
	List<Docteur> getDocteurs();

	Docteur saveDocteur(Docteur docteur);

	Docteur getDocteurByID(Long id);

	Docteur updateDocteur(Long id,Docteur docteur);

	void deleteByID(Long id);

	void deleteDocteurs();
}
