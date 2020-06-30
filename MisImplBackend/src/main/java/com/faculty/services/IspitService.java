package com.faculty.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.json_entities.JSONIspit;
import com.faculty.repository.IspitRepository;

@Service
public class IspitService implements AbstractService {

	private IspitRepository ir;

	public IspitService(@Autowired IspitRepository ir) {

		this.ir = ir;
	}
	
	public ResponseEntity<Boolean> savePrijava(String i) {

		try {
			
			var ispit = parseString(i);
			ir.save(ispit);

			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<JSONIspit>> getPrijavljeniIspiti(Integer idStudent) {

		var lista = ir.findAllPrijavljeni(idStudent)
				      .stream().map(x -> parseIspitToJson(x))
				      .collect(Collectors.toList());

		return new ResponseEntity<List<JSONIspit>>(lista, HttpStatus.OK);
	}

	public ResponseEntity<List<JSONIspit>> getStatusIspits(Integer idStudent) {

		var lista = ir.findAllPolozeni(idStudent)
				      .stream()
				      .map(x -> parseIspitToJson(x))
				      .collect(Collectors.toList());

		return new ResponseEntity<List<JSONIspit>>(lista, HttpStatus.OK);
	}

}
