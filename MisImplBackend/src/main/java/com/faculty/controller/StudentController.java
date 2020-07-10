package com.faculty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.i_controller.IStudent;
import com.faculty.json_entities.JSONStudent;
import com.faculty.services.StudentService;

@RestController
public class StudentController implements IStudent<JSONStudent>{
	
	private StudentService ss;
	
	public StudentController(@Autowired StudentService ss) {
		if(ss != null)
			this.ss = ss;
	}
	
	@Override
	public ResponseEntity<JSONStudent> getStudent(Integer idStudent){
		return ss.findStudent(idStudent);
	}
	
	@Override
	public ResponseEntity<List<JSONStudent>> returnStudents(Integer idPredmet){
		return ss.getStudents(idPredmet);
	}

}
