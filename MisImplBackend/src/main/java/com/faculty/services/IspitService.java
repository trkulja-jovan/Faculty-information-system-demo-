package com.faculty.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faculty.i_service.BaseService;
import com.faculty.i_service.IServiceIspit;
import com.faculty.json_entities.JSONIspit;
import com.faculty.repository.IspitRepository;

@Service
public class IspitService implements IServiceIspit<JSONIspit>, BaseService {

	private IspitRepository ir;

	public IspitService(@Autowired IspitRepository ir) {

		this.ir = ir;
	}
	
	@Override
	public ResponseEntity<JSONIspit> savePrijava(String i) {

		try {
			
			var ispit = parseStringToIspit(i);
			ir.save(ispit);

			return new ResponseEntity<JSONIspit>(parseIspitToJson(ispit), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
	public ResponseEntity<List<JSONIspit>> getPrijavljeniIspiti(Integer idStudent) {

		var lista = ir.findAllPrijavljeni(idStudent)
				      .stream().map(x -> parseIspitToJson(x))
				      .collect(Collectors.toList());

		return new ResponseEntity<List<JSONIspit>>(lista, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<JSONIspit>> getStatusIspits(Integer idStudent) {

		var lista = ir.findAllPolozeni(idStudent)
				      .stream()
				      .map(x -> parseIspitToJson(x))
				      .collect(Collectors.toList());

		return new ResponseEntity<List<JSONIspit>>(lista, HttpStatus.OK);
	}

}
