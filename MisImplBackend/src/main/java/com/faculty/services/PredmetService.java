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
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Predmet;
import model.Profesor;

@Service
public class PredmetService {
	
	@Autowired
	PredmetRepository pr;
	
	private static ObjectMapper _mapper = new ObjectMapper();
	
	public ResponseEntity<List<JSONPredProf>> getPredmetForStud(Integer idStudent){
		var list = pr.findStudents(idStudent)
				     .stream()
				     .map(PredmetService::parseEntityToJSONPredProf)
				     .collect(Collectors.toList());
		return new ResponseEntity<List<JSONPredProf>>(list, OK);
	}
	
	public ResponseEntity<List<JSONPredmet>> getPredmetForProf(JSONProfesor profesor){
		var list = pr.findByProfesor(parseJSONToEntity(profesor))
				     .stream()
				     .map(PredmetService::parseEntityToJSON)
				     .collect(Collectors.toList());
		return new ResponseEntity<List<JSONPredmet>>(list, OK);
	} 
	
	private static JSONPredProf parseEntityToJSONPredProf(Predmet predmet){
		return new JSONPredProf (parseEntityToJSON(predmet), parseEntityToJSONProf(predmet.getProfesor()));
	}
	
	private static JSONProfesor parseEntityToJSONProf(Profesor p){
		return new JSONProfesor(p.getIdProfesor(), p.getIme(), p.getJmbg(), p.getPrezime());
	}
	
	private static JSONPredmet parseEntityToJSON(Predmet predmet){
		return new JSONPredmet(predmet.getIdPredmet(),
							   predmet.getEspb(),
							   predmet.getNazivPredmeta(),
							   predmet.getSemestar());
	}
	
	private Profesor parseJSONToEntity(JSONProfesor prof) {
		return _mapper.convertValue(prof, Profesor.class);
	}
	
}
