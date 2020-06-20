package com.faculty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Prijava;

public interface PrijavaRepository extends JpaRepository<Prijava, Integer>{
	
	public List<Prijava> findByIspitniRok(String ispitniRok);

}
