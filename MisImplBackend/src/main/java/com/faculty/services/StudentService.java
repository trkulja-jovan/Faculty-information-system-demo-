package com.faculty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.faculty.json_entities.JSONStudent;
import com.faculty.repository.StudentRepository;

import model.Student;

@Service
public class StudentService {
	
	private StudentRepository sr;
	
	public StudentService(@Autowired StudentRepository sr) {
		if(sr != null)
			this.sr = sr;
	}
	
	public ResponseEntity<JSONStudent> findStudent(Integer idStudent){
		
		var student = sr.findById(idStudent).get();
		assert student != null;
		return new ResponseEntity<JSONStudent>(parseEntityToJson(student), HttpStatus.OK);
		
	}
	
	private JSONStudent parseEntityToJson(@NonNull Student student) {
		return new JSONStudent(student.getIdOsoba(),
							   student.getBrIndeksa(), 
							   student.getGodinaStudija(),
							   student.getIme(), 
							   student.getJmbg(), 
							   student.getPrezime());
	}

}
