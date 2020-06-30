package com.faculty.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.json_entities.JSONPredmet;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.json_entities.JSONStudent;
import com.faculty.repository.PredmetRepository;
import com.faculty.repository.ProfesorRepository;
import com.faculty.repository.StudentRepository;

@Service
public class ProfesorService implements AbstractService{
	
	private ProfesorRepository pr;
	private PredmetRepository prer;
	private StudentRepository sr;
	
	public ProfesorService(@Autowired ProfesorRepository pr, 
			               @Autowired PredmetRepository prer,
			               @Autowired StudentRepository sr) {
		this.pr = pr;
		this.prer = prer;
		this.sr = sr;
	}
	
	public ResponseEntity<List<JSONProfesor>> getProfesors(){
		
		var list = pr.findAll()
				     .stream()
				     .map(x -> parseProfesorToJSON(x))
				     .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONProfesor>>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<List<JSONPredmet>> getPredmets(Integer idProfesor){
		
		var list = prer.findByProfesor(idProfesor)
				       .stream()
				       .map(x -> parsePredmetToJSON(x))
				       .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONPredmet>>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<List<JSONStudent>> getStudents(Integer idPredmet){
		
		var list = sr.findAllStudentsForPredmet(idPredmet)
				     .stream()
				     .map(x -> parseStudentToJson(x))
				     .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONStudent>>(list, HttpStatus.OK);
	}

}
