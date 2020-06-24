package com.faculty.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.repository.PrijavaRepository;

import model.Prijava;

@Service
public class PrijavaService {
	
	private PrijavaRepository pr;
	
	public PrijavaService(@Autowired PrijavaRepository pr) {
		if(pr != null)
			this.pr = pr;
	}
	
	public ResponseEntity<Prijava> savePrijavaIspit(Prijava p){
		
		var prijava = pr.save(p);
		
		return new ResponseEntity<Prijava>(prijava, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Prijava>> getSvePrijave(String ispitniRok){
		
		var prijave = pr.findByIspitniRok(ispitniRok);
		
		return new ResponseEntity<List<Prijava>>(prijave, HttpStatus.OK);
	}

}
