package com.example.hopital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hopital.DAO.PatientDAO;
import com.example.hopital.models.Patient;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	public List<Patient> getPatients() {
		List<Patient> patients = (List<Patient>) patientDAO.findAll();
		if(!patients.isEmpty()) {
			return patients;
		}
		else {
			return null;
		}
	}

	@Override
	public Patient savePatient(Patient patient) {
		Patient _patient = new Patient();
		_patient.setPrenom(patient.getPrenom());
		_patient.setNom(patient.getNom());
		patientDAO.save(_patient);
		return _patient;
	}

	@Override
	public Patient getPatientByID(Long id) {
		Optional<Patient> retrievedPatient = patientDAO.findById(id);
		if(retrievedPatient.isPresent()) {
			return retrievedPatient.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		Optional<Patient> retrievedPatient = patientDAO.findById(id);
		Patient _patient = retrievedPatient.get();
		_patient.setPrenom(patient.getPrenom());
		_patient.setNom(patient.getNom());
		patientDAO.save(_patient);
		return _patient;
	}

	@Override
	public void deleteByID(Long id) {
		patientDAO.deleteById(id);		
	}

	@Override
	public void deletePatients() {
		patientDAO.deleteAll();
	}
	
}
