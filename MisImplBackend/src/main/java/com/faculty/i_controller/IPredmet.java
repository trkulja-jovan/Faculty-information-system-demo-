package com.faculty.i_controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IPredmet <T, E> {
	
	@GetMapping("/getPredmeti")
	ResponseEntity<List<T>> returnPredmets(@RequestParam("idProfesor") Integer idProfesor);
	
	@GetMapping("/getPredmets")
	ResponseEntity<List<E>> getPredmetForStud(@RequestParam("idStudent") Integer idStudent);

}
