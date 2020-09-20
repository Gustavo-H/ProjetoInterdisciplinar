package br.com.car.rent.controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.car.rent.model.Client;
import br.com.car.rent.model.Rental;
import br.com.car.rent.model.ResponseModel;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value="/car-rent/rents")

public class RentalController {
	@GetMapping
	public ResponseEntity<ResponseModel> getById(int id) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> getByClient(int id) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> getByEmployee(int id) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> insert(Rental r) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> update(Rental r) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> getAll(Calendar date) throws SQLException {
		return null;
	}
}
