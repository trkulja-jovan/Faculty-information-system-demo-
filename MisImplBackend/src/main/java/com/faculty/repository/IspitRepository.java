package com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Ispit;

@Repository
public interface IspitRepository extends JpaRepository<Ispit, Integer>{

}
