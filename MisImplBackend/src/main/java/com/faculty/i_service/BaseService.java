package com.faculty.i_service;

import com.faculty.json_entities.JSONIspit;
import com.faculty.json_entities.JSONPredProf;
import com.faculty.json_entities.JSONPredmet;
import com.faculty.json_entities.JSONProfesor;
import com.faculty.json_entities.JSONStudent;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Ispit;
import model.Predmet;
import model.Profesor;
import model.Student;

public interface BaseService {

	final ObjectMapper _mapper = new ObjectMapper();

	default JSONStudent parseStudentToJson(Student s) {
		return new JSONStudent(s.getIdOsoba(), s.getBrIndeksa(), s.getGodinaStudija(), s.getIme(), s.getJmbg(),
				s.getPrezime());
	}

	default JSONPredProf parseEntityToJSONPredProf(Predmet predmet) {
		return new JSONPredProf(parsePredmetToJSON(predmet), parseProfesorToJSON(predmet.getProfesor()));
	}

	default JSONProfesor parseProfesorToJSON(Profesor p) {
		return new JSONProfesor(p.getIdProfesor(), p.getIme(), p.getJmbg(), p.getPrezime());
	}

	default JSONPredmet parsePredmetToJSON(Predmet predmet) {
		return new JSONPredmet(predmet.getIdPredmet(), predmet.getEspb(), predmet.getNazivPredmeta(),
				predmet.getSemestar());
	}
	
	default JSONIspit parseIspitToJson(Ispit i) {
		return new JSONIspit(i.getOcena(),
						     i.getDatumPolaganja().toString(),
						     parsePredmetToJSON(i.getPredmet()),
						     parseStudentToJson(i.getStudent()));
	}

	default Profesor parseJSONToEntity(JSONProfesor prof) {
		return _mapper.convertValue(prof, Profesor.class);
	}
	
	default Ispit parseJsonToIspit(JSONIspit i) {
		return _mapper.convertValue(i, Ispit.class);
	}
	
	default Predmet parseJsonToPredmet(JSONPredmet pred) {
		return _mapper.convertValue(pred, Predmet.class);
	}
	
	default Student parseJsonToStudent(JSONStudent s) {
		return _mapper.convertValue(s, Student.class);
	}
	
	default Ispit parseStringToIspit(String ispit) throws Exception {
		return _mapper.readValue(ispit, Ispit.class);
	}
}
