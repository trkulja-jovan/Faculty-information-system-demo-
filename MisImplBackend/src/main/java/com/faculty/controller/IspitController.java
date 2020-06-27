package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(path="/prijaviIspit", produces="application/json")
	public ResponseEntity<Boolean> saveIspit(@RequestParam("idStudent") Integer idStudent,
											 @RequestParam("idPredmet") Integer idPredmet){
		return is.savePrijava(idStudent, idPredmet);
	}
	
	@RequestMapping(path="/getPrijavljeniIspiti", produces="application/json")
	public ResponseEntity<List<JSONIspit>> getPrijavljeni(@RequestParam("idStudent") Integer idStudent){
		return is.getPrijavljeniIspiti(idStudent);
	}
	
	@RequestMapping(path="/getPolozeni", produces="application/json")
	public ResponseEntity<List<JSONIspit>> getStatusIspita(@RequestParam("idStudent") Integer idStudent){
		return is.getStatusIspits(idStudent);
	}

}
