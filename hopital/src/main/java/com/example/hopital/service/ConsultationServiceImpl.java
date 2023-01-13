package com.example.hopital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hopital.DAO.ConsultationDAO;
import com.example.hopital.models.Consultation;

public class ConsultationServiceImpl implements ConsultationService{

	@Autowired
	private ConsultationDAO consultationDAO;
	
	@Override
	public List<Consultation> getConsultations() {
		List<Consultation> consultations = (List<Consultation>) consultationDAO.findAll();
		if(!consultations.isEmpty()) {
			return consultations;
		}
		else {
			return null;
		}
	}

	@Override
	public Consultation saveConsultation(Consultation consultation) {
		Consultation _consultation = new Consultation();
		_consultation.setIdConsultation(consultation.getIdConsultation());
		_consultation.setDate(consultation.getDate());
		_consultation.setPatient(consultation.getPatient());
		_consultation.setDocteur(consultation.getDocteur());
		consultationDAO.save(_consultation);
		return _consultation;
	}

	@Override
	public Consultation getConsultationByID(Long id) {
		Optional<Consultation> retrievedConsultation = consultationDAO.findById(id);
		if(retrievedConsultation.isPresent()) {
			return retrievedConsultation.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Consultation updateConsultation(Long id, Consultation consultation) {
		Optional<Consultation> retrievedConsultation = consultationDAO.findById(id);
		Consultation _consultation = retrievedConsultation.get();
		_consultation.setIdConsultation(consultation.getIdConsultation());
		_consultation.setDate(consultation.getDate());
		_consultation.setPatient(consultation.getPatient());
		_consultation.setDocteur(consultation.getDocteur());
		consultationDAO.save(_consultation);
		return _consultation;
	}

	@Override
	public void deleteConsultationByID(Long id) {
		consultationDAO.deleteById(id);
	}

	@Override
	public void deleteConsultations() {
		consultationDAO.deleteAll();
	}

}
