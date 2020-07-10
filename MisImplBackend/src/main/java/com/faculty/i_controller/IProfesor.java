package com.faculty.i_controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface IProfesor <T>{
	
	@GetMapping("/getAllProfesors")
	ResponseEntity<List<T>> returnProfesors();

}
