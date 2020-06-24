package com.faculty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.repository.IspitRepository;

import model.Ispit;

@Service
public class IspitService{
	
	private IspitRepository ir;
	
	public IspitService(@Autowired IspitRepository ir) {
		if(ir != null)
			this.ir = ir;
	}
	
	public ResponseEntity<Ispit> saveIs(Ispit ispit){
		
		var i = ir.save(ispit);
		return new ResponseEntity<Ispit>(i, HttpStatus.OK);
	}

}
