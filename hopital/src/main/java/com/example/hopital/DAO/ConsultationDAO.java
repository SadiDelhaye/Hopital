package com.example.hopital.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hopital.models.Consultation;

@Repository
public interface ConsultationDAO extends CrudRepository<Consultation, Long>{

}
