package com.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.services.IspitService;

import model.Ispit;

@RestController
public record IspitController(@Autowired IspitService is) {
	
	@PostMapping(path="/saveIspit", produces="application/json")
	public ResponseEntity<Ispit> saveIspit(@RequestBody Ispit i){
		
		return is.saveIs(i);
	}

}
