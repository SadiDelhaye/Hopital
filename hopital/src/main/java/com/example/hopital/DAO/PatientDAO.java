package com.example.hopital.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hopital.models.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long>{

}
