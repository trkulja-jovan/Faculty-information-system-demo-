package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.i_controller.IIspit;
import com.faculty.json_entities.JSONIspit;
import com.faculty.services.IspitService;

@RestController
public class IspitController implements IIspit<JSONIspit>{

	private IspitService is;

	public IspitController(@Autowired IspitService is) {
		this.is = is;
	}
	
	@Override
	public ResponseEntity<JSONIspit> saveIspit(String ispit) {
		return is.savePrijava(ispit);
	}

	@Override
	public ResponseEntity<List<JSONIspit>> getPrijavljeni(Integer idStudent) {
		return is.getPrijavljeniIspiti(idStudent);
	}

	@Override
	public ResponseEntity<List<JSONIspit>> getStatusIspita(Integer idStudent) {
		return is.getStatusIspits(idStudent);
	}

}
