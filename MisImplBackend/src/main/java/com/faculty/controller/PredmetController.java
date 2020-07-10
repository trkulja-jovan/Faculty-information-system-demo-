package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.i_controller.IPredmet;
import com.faculty.json_entities.JSONPredProf;
import com.faculty.json_entities.JSONPredmet;
import com.faculty.services.PredmetService;

@RestController
public class PredmetController implements IPredmet<JSONPredmet, JSONPredProf>{
	
	private PredmetService ps;
	
	public PredmetController(@Autowired PredmetService ps) {
		if(ps != null)
			this.ps = ps;
	}
	
	@Override
	public ResponseEntity<List<JSONPredProf>> getPredmetForStud(Integer idStudent){
		
		return ps.getPredmetForStud(idStudent);
	}
	
	@Override
	public ResponseEntity<List<JSONPredmet>> returnPredmets(Integer idProfesor){
		return ps.getPredmets(idProfesor);
	}
}
