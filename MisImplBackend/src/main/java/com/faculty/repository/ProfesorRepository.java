package com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
	

}
