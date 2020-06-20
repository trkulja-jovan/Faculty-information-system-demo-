package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.services.PrijavaService;

import model.Prijava;

@RestController
public record PrijavaController(@Autowired PrijavaService ps) {
	
	@PostMapping(path="/savePrijava", produces="application/json")
	public ResponseEntity<Prijava> savePrijava(@RequestBody Prijava p){
		return ps.savePrijavaIspit(p);
	}
	
	@RequestMapping("/getSvePrijave{ispitniRok}")
	public ResponseEntity<List<Prijava>> getPrijave(@RequestParam("ispitniRok") String ispitniRok){
		return ps.getSvePrijave(ispitniRok);
	}

}
