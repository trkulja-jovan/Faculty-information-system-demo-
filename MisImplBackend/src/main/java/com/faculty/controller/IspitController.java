package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.json_entities.JSONIspit;
import com.faculty.services.IspitService;

@RestController
public class IspitController {

	private IspitService is;

	public IspitController(@Autowired IspitService is) {
		this.is = is;
	}
	
	@PostMapping(path = "/prijaviIspit", produces = "application/json")
	public ResponseEntity<Boolean> saveIspit(@RequestBody String ispit) {
		return is.savePrijava(ispit);
	}

	@GetMapping("/getPrijavljeniIspiti")
	public ResponseEntity<List<JSONIspit>> getPrijavljeni(@RequestParam("idStudent") Integer idStudent) {
		return is.getPrijavljeniIspiti(idStudent);
	}

	@GetMapping("/getPolozeni")
	public ResponseEntity<List<JSONIspit>> getStatusIspita(@RequestParam("idStudent") Integer idStudent) {
		return is.getStatusIspits(idStudent);
	}

}
