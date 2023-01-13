package com.example.hopital.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.hopital.models.Docteur;

@Repository
public interface DocteurDAO extends CrudRepository<Docteur, Long> {

}
