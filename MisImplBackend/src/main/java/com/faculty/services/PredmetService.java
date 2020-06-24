package com.faculty.services;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.json_entities.JSONPredProf;
import com.faculty.json_entities.JSONPredmet;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.repository.PredmetRepository;

@Service
public class PredmetService implements AbstractService {
	
	@Autowired
	PredmetRepository pr;
	
	public ResponseEntity<List<JSONPredProf>> getPredmetForStud(Integer idStudent){
		var list = pr.findStudents(idStudent)
				     .stream()
				     .map(x -> parseEntityToJSONPredProf(x))
				     .collect(Collectors.toList());
		return new ResponseEntity<List<JSONPredProf>>(list, OK);
	}
	
	public ResponseEntity<List<JSONPredmet>> getPredmetForProf(JSONProfesor profesor){
		var list = pr.findByProfesor(parseJSONToEntity(profesor))
				     .stream()
				     .map(x -> parsePredmetToJSON(x))
				     .collect(Collectors.toList());
		return new ResponseEntity<List<JSONPredmet>>(list, OK);
	} 
	
	
	
}
