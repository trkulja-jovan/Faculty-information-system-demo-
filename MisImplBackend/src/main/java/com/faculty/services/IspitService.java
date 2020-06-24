package com.faculty.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.json_entities.JSONIspit;
import com.faculty.repository.IspitRepository;
import com.faculty.repository.PredmetRepository;
import com.faculty.repository.StudentRepository;

import model.Ispit;

@Service
public class IspitService implements AbstractService {
	
	private IspitRepository ir;
	private StudentRepository sr;
	private PredmetRepository pr;
	
	public IspitService(@Autowired IspitRepository ir,
						@Autowired StudentRepository sr,
						@Autowired PredmetRepository pr) {
		
		this.ir = ir;
		this.sr = sr;
		this.pr = pr;
	}
	
	public ResponseEntity<Boolean> savePrijava(Integer idStudent, Integer idPredmet){
		
		try {
			var student = sr.findById(idStudent).get();
			var predmet = pr.findById(idPredmet).get();

			var i = new Ispit();
			
			i.setOcena(0);
			i.setDatumPolaganja(new Date());
			i.setStudent(student);
			i.setPredmet(predmet);
			
			ir.save(i);
			
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<List<JSONIspit>> getPrijavljeniIspiti(Integer idStudent){
		
		var lista = ir.findAllPrijavljeni(idStudent)
				      .stream()
				      .map(x -> parseIspitToJson(x))
				      .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONIspit>>(lista, HttpStatus.OK);
	}
	
	public ResponseEntity<List<JSONIspit>> getStatusIspits(Integer idStudent){
		
		var lista = ir.findAllPolozeni(idStudent)
				      .stream()
				      .map(x -> parseIspitToJson(x))
				      .collect(Collectors.toList());
		
		return new ResponseEntity<List<JSONIspit>>(lista, HttpStatus.OK);
	}

}
