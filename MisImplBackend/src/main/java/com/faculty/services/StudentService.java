package com.faculty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.json_entities.JSONStudent;
import com.faculty.repository.StudentRepository;

@Service
public class StudentService implements AbstractService {
	
	private StudentRepository sr;
	
	public StudentService(@Autowired StudentRepository sr) {
		if(sr != null)
			this.sr = sr;
	}
	
	public ResponseEntity<JSONStudent> findStudent(Integer idStudent){
		
		var student = sr.findById(idStudent).get();
		assert student != null;
		return new ResponseEntity<JSONStudent>(parseStudentToJson(student), HttpStatus.OK);
		
	}
	
	

}
