package com.faculty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("select s from Student s inner join s.predmets p where p.idPredmet like :idPredmet")
	public List<Student> findAllStudentsForPredmet(@Param("idPredmet") Integer idPredmet);

}
