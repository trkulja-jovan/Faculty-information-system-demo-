package com.faculty.i_service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IServicePredmet<T, E> {
	
	ResponseEntity<List<E>> getPredmetForStud(Integer idStudent);
	
	ResponseEntity<List<T>> getPredmets(Integer idProfesor);

}
