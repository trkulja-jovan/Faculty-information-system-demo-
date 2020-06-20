package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.services.PredmetService;

import model.Predmet;
import model.Profesor;

@RestController
public record PredmetController(@Autowired PredmetService sr) {
	
	@RequestMapping("/getPredmets")
	public ResponseEntity<List<Predmet>> getPredmetForStud(@RequestParam("idStudent") Integer idStudent){
		return sr.getPredmetForStud(idStudent);
	}
	
	@PostMapping("/getPredmetsForProfesor")
	public ResponseEntity<List<Predmet>> getPredmetForPro(@RequestBody Profesor profesor){
		return sr.getPredmetForProf(profesor);
	}
}
