package com.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculty.json_entities.JSONStudent;
import com.faculty.services.StudentService;

@RestController
public class StudentController {
	
	private StudentService ss;
	
	public StudentController(@Autowired StudentService ss) {
		if(ss != null)
			this.ss = ss;
	}
	
	@GetMapping("/getStudentInfo")
	public ResponseEntity<JSONStudent> getStudent(@RequestParam("idStudent") Integer idStudent){
		return ss.findStudent(idStudent);
	}

}
