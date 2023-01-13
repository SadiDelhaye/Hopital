package com.example.hopital.service;

import java.util.List;

import com.example.hopital.models.Patient;

public interface PatientService {

	List<Patient> getPatients();

	Patient savePatient(Patient patient);

	Patient getPatientByID(Long id);

	Patient updatePatient(Long id,Patient patient);

	void deleteByID(Long id);

	void deletePatients();

}
