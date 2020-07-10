package com.faculty.services;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.i_service.BaseService;
import com.faculty.i_service.IServicePredmet;
import com.faculty.json_entities.JSONPredProf;
import com.faculty.json_entities.JSONPredmet;
import com.faculty.repository.PredmetRepository;

@Service
public class PredmetService implements IServicePredmet<JSONPredmet, JSONPredProf>, BaseService {
	
	private PredmetRepository pr;
	
	public PredmetService(@Autowired PredmetRepository pr) {
		this.pr = pr;
	}
	
	@Override
	public ResponseEntity<List<JSONPredProf>> getPredmetForStud(Integer idStudent){
		var list = pr.findStudents(idStudent)
				     .stream()
				     .map(x -> parseEntityToJSONPredProf(x))
				     .collect(Collectors.toList());
		return new ResponseEntity<List<JSONPredProf>>(list, OK);
	}
	
	@Override
	public ResponseEntity<List<JSONPredmet>> getPredmets(Integer idProfesor){
		
		var list = pr.findByProfesor(idProfesor)
				       .stream()
				       .map(x -> parsePredmetToJSON(x))
				       .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONPredmet>>(list, HttpStatus.OK);
	}
	
	
}
