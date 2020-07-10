package com.faculty.i_service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IServiceProfesor<T> {
	
	ResponseEntity<List<T>> getProfesors();

}
