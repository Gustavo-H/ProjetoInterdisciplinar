package br.com.car.rent.controller;

import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.car.rent.model.Group;
import br.com.car.rent.model.ResponseModel;

public class GroupController {
	@GetMapping
	public ResponseEntity<ResponseModel> getById(int id) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> getByName(String name) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> insert(Group g) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> update(Group g) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> delete(int id) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> getAll() throws SQLException {
		return null;
	}
}
