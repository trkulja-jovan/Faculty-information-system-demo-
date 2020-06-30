package com.faculty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Predmet;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Integer>{
	
	@Query("select p from Predmet p inner join p.students s where s.idOsoba like :idStudent")
	public List<Predmet> findStudents(@Param("idStudent") Integer idStudent);
	
	@Query("select p from Predmet p where p.profesor.idProfesor like :idProfesor")
	public List<Predmet> findByProfesor(@Param("idProfesor") Integer idProfesor);

}
