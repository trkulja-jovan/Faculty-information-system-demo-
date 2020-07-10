package com.faculty.i_service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IServiceStudent<T> {
	
	ResponseEntity<T> findStudent(Integer idStudent);
	
	ResponseEntity<List<T>> getStudents(Integer idPredmet);

}
