package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.i_controller.IProfesor;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.services.ProfesorService;

@RestController
public class ProfesorController implements IProfesor <JSONProfesor> {
	
	private ProfesorService ps;
	
	public ProfesorController(@Autowired ProfesorService ps) {
		this.ps = ps;
	}
	
	@Override
	public ResponseEntity<List<JSONProfesor>> returnProfesors(){
		return ps.getProfesors();
	}

}
