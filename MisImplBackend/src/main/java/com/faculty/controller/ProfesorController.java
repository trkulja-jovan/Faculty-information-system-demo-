package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.json_entities.JSONPredmet;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.json_entities.JSONStudent;
import com.faculty.services.ProfesorService;

@RestController
public class ProfesorController {
	
	private ProfesorService ps;
	
	public ProfesorController(@Autowired ProfesorService ps) {
		this.ps = ps;
	}
	
	@GetMapping(path = "/getAllProfesors", produces = "application/json")
	public ResponseEntity<List<JSONProfesor>> returnProfesors(){
		return ps.getProfesors();
	}
	
	@RequestMapping("/getPredmeti")
	public ResponseEntity<List<JSONPredmet>> returnPredmets(@RequestParam("idProfesor") Integer idProfesor){
		return ps.getPredmets(idProfesor);
	}
	
	@RequestMapping("/getStudents")
	public ResponseEntity<List<JSONStudent>> returnStudents(@RequestParam("idPredmet") Integer idPredmet){
		return ps.getStudents(idPredmet);
	}

}
