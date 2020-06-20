package com.faculty.services;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.repository.PredmetRepository;

import model.Predmet;
import model.Profesor;

@Service
public record PredmetService(@Autowired PredmetRepository sr) {
	
	public ResponseEntity<List<Predmet>> getPredmetForStud(Integer idStudent){
		var list = sr.findStudents(idStudent);
		return new ResponseEntity<List<Predmet>>(list, OK);
	}
	
	public ResponseEntity<List<Predmet>> getPredmetForProf(Profesor profesor){
		var list = sr.findByProfesor(profesor);
		return new ResponseEntity<List<Predmet>>(list, OK);
	}
	
}
