package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.json_entities.JSONPredProf;
import com.faculty.json_entities.JSONPredmet;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.services.PredmetService;

@RestController
public class PredmetController {
	
	private PredmetService ps;
	
	public PredmetController(@Autowired PredmetService ps) {
		if(ps != null)
			this.ps = ps;
	}
	
	@RequestMapping(path = "/getPredmets", produces="application/json")
	public ResponseEntity<List<JSONPredProf>> getPredmetForStud(@RequestParam("idStudent") Integer idStudent){
		return ps.getPredmetForStud(idStudent);
	}
	
	@PostMapping("/getPredmetsForProfesor")
	public ResponseEntity<List<JSONPredmet>> getPredmetForPro(@RequestBody JSONProfesor profesor){
		return ps.getPredmetForProf(profesor);
	}
}
