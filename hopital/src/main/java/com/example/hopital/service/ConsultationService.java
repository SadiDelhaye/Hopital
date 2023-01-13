package com.example.hopital.service;

import java.util.List;

import com.example.hopital.models.Consultation;

public interface ConsultationService {
	List<Consultation> getConsultations();
	
	Consultation saveConsultation(Consultation consultation);
	
	Consultation getConsultationByID(Long id);
	
	Consultation updateConsultation(Long id,Consultation consultation);
	
	void deleteConsultationByID(Long id);
	
	void deleteConsultations();
}
