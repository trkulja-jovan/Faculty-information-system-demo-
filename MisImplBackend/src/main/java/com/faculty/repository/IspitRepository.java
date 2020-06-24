package com.faculty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Ispit;

@Repository
public interface IspitRepository extends JpaRepository<Ispit, Integer>{
	
	@Query("select i from Ispit i where i.ocena = 0 and i.student.idOsoba like :idStudent")
	public List<Ispit> findAllPrijavljeni(@Param("idStudent") Integer idStudent);
	
	@Query("select i from Ispit i where i.ocena >= 5 and i.student.idOsoba like :idStudent")
	public List<Ispit> findAllPolozeni(@Param("idStudent") Integer idStudent);

}
