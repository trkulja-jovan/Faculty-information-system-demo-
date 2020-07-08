package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.json_entities.JSONPredProf;
import com.faculty.services.PredmetService;

@RestController
public class PredmetController {
	
	private PredmetService ps;
	
	public PredmetController(@Autowired PredmetService ps) {
		if(ps != null)
			this.ps = ps;
	}
	
	@GetMapping("/getPredmets")
	public ResponseEntity<List<JSONPredProf>> getPredmetForStud(@RequestParam("idStudent") Integer idStudent){
		
		return ps.getPredmetForStud(idStudent);
	}
}
