package com.faculty.i_controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IStudent<T> {
	
	@GetMapping("/getStudentInfo")
	ResponseEntity<T> getStudent(@RequestParam("idStudent") Integer idStudent);
	
	@GetMapping("/getStudents")
	ResponseEntity<List<T>> returnStudents(@RequestParam("idPredmet") Integer idPredmet);
}
