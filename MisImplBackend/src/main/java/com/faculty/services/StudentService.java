package com.faculty.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.i_service.BaseService;
import com.faculty.i_service.IServiceStudent;
import com.faculty.json_entities.JSONStudent;
import com.faculty.repository.StudentRepository;

@Service
public class StudentService implements IServiceStudent<JSONStudent>, BaseService {
	
	private StudentRepository sr;
	
	public StudentService(@Autowired StudentRepository sr) {
		if(sr != null)
			this.sr = sr;
	}
	
	@Override
	public ResponseEntity<JSONStudent> findStudent(Integer idStudent){
		
		var student = sr.findById(idStudent).get();
		assert student != null;
		return new ResponseEntity<JSONStudent>(parseStudentToJson(student), HttpStatus.OK);
		
	}
	
	@Override
	public ResponseEntity<List<JSONStudent>> getStudents(Integer idPredmet){
		
		var list = sr.findAllStudentsForPredmet(idPredmet)
				     .stream()
				     .map(x -> parseStudentToJson(x))
				     .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONStudent>>(list, HttpStatus.OK);
	}

}
