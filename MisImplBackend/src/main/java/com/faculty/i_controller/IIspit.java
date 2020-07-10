package com.faculty.i_controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IIspit<T> {
	
	@PostMapping("/prijaviIspit")
	ResponseEntity<T> saveIspit(@RequestBody String ispit);
	
	@GetMapping("/getPrijavljeniIspiti")
	ResponseEntity<List<T>> getPrijavljeni(@RequestParam("idStudent") Integer idStudent);
	
	@GetMapping("/getPolozeni")
	ResponseEntity<List<T>> getStatusIspita(@RequestParam("idStudent") Integer idStudent);

}
