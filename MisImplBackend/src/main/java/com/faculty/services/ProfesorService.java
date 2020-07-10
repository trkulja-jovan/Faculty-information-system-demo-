package com.faculty.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.i_service.BaseService;
import com.faculty.i_service.IServiceProfesor;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.repository.ProfesorRepository;

@Service
public class ProfesorService implements IServiceProfesor<JSONProfesor>, BaseService{
	
	private ProfesorRepository pr;
	
	public ProfesorService(@Autowired ProfesorRepository pr) {
		this.pr = pr;
	}
	
	@Override
	public ResponseEntity<List<JSONProfesor>> getProfesors(){
		
		var list = pr.findAll()
				     .stream()
				     .map(x -> parseProfesorToJSON(x))
				     .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONProfesor>>(list, HttpStatus.OK);
	}
	

}
