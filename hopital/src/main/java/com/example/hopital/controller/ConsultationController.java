package com.example.hopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hopital.models.Consultation;
import com.example.hopital.service.ConsultationService;

@RestController
@RequestMapping(path = "/api/consultation")
public class ConsultationController {
	
	@Autowired
	ConsultationService consultationService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Consultation>> getConsultations(){
		try {
			List<Consultation> categories = consultationService.getConsultations();
			return new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation){
		try {
			return new ResponseEntity<Consultation>(consultationService.saveConsultation(consultation), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "consultation/{id}")
	public ResponseEntity<Consultation> getConsultationByID(@PathVariable Long id){
		try {
			if(consultationService.getConsultationByID(id) != null) {
				return new ResponseEntity<Consultation>(consultationService.getConsultationByID(id), HttpStatus.OK);
			}
			return new ResponseEntity<Consultation>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "consultation/{id}")
	public void deleteConsultationByID(@PathVariable Long id) {
		consultationService.deleteConsultationByID(id);
	}
	
}
