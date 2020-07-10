package com.faculty.i_service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IServiceIspit<T> {
	
	ResponseEntity<T> savePrijava(String ispit);
	
	ResponseEntity<List<T>> getPrijavljeniIspiti(Integer idStudent);
	
	ResponseEntity<List<T>> getStatusIspits(Integer idStudent);
	

}
