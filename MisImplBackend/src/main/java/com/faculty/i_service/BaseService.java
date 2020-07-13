package com.faculty.i_service;

import com.faculty.json_entities.JSONIspit;
import com.faculty.json_entities.JSONPredProf;
import com.faculty.json_entities.JSONPredmet;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.json_entities.JSONStudent;
import com.faculty.json_entities.JsonEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Ispit;
import model.Predmet;
import model.Profesor;
import model.Student;

public class BaseService {

	final static ObjectMapper _mapper = new ObjectMapper();
	
	protected static JsonEntity parseEntityToJson(Object type, boolean flag) {
		
		if(flag)
			return parseEntityToJsonPredProf((Predmet) type);
		
		if(type instanceof Student) {
			return parseStudentToJson((Student)type);
		} else if(type instanceof Profesor) {
			return parseProfesorToJson((Profesor) type);
		} else if(type instanceof Ispit) {
			return parseIspitToJson((Ispit) type);
		} else if(type instanceof Predmet) {
			return parsePredmetToJson((Predmet) type);
		} else {
			throw new RuntimeException(type.getClass().toString() + " must be Entity!");
			
		}
	}
	
	protected static Ispit parseStringToIspit(String ispit) throws Exception {
		return _mapper.readValue(ispit, Ispit.class);
	}
	
	private static JSONStudent parseStudentToJson(Student s) {
		return new JSONStudent(s.getIdOsoba(), s.getBrIndeksa(), s.getGodinaStudija(), s.getIme(), s.getJmbg(),
				s.getPrezime());
	}

	private static JSONPredProf parseEntityToJsonPredProf(Predmet predmet) {
		return new JSONPredProf(parsePredmetToJson(predmet), parseProfesorToJson(predmet.getProfesor()));
	}

	private static JSONProfesor parseProfesorToJson(Profesor p) {
		return new JSONProfesor(p.getIdProfesor(), p.getIme(), p.getJmbg(), p.getPrezime());
	}

	private static JSONPredmet parsePredmetToJson(Predmet predmet) {
		return new JSONPredmet(predmet.getIdPredmet(), predmet.getEspb(), predmet.getNazivPredmeta(),
				predmet.getSemestar());
	}
	
	private static JSONIspit parseIspitToJson(Ispit i) {
		return new JSONIspit(i.getOcena(),
						     i.getDatumPolaganja().toString(),
						     parsePredmetToJson(i.getPredmet()),
						     parseStudentToJson(i.getStudent()));
	}
}
