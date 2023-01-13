package com.example.hopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hopital.models.Docteur;
import com.example.hopital.service.DocteurService;

@RestController
@RequestMapping(path = "/api/docteurs")
public class DocteurController {

	@Autowired
	private DocteurService docteurService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Docteur>> getDocteurs(){
		try {
			List<Docteur> docteurs = docteurService.getDocteurs();
			return new ResponseEntity<>(docteurs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Docteur> saveDocteur(@RequestBody Docteur docteur) {
		try {
			return new ResponseEntity<>(docteurService.saveDocteur(docteur), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Docteur> getDocteurByID(@PathVariable Long id) {
		try {
			Docteur _docteur = docteurService.getDocteurByID(id);
			if(_docteur != null) {
				return new ResponseEntity<>(_docteur, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Docteur> updateDocteur(@PathVariable Long id,@RequestBody Docteur docteur) {
		try {
			return new ResponseEntity<Docteur>(docteurService.updateDocteur(id, docteur), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}")
	public void deleteDocteurByID(@PathVariable Long id) {
		docteurService.deleteByID(id);
	}

	@DeleteMapping(path = "/")
	public void deleteDocteurs() {
		docteurService.deleteDocteurs();
	}
}
