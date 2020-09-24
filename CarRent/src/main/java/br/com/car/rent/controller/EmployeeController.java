package br.com.car.rent.controller;

import java.sql.SQLException;
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
import br.com.car.rent.model.Employee;
import br.com.car.rent.model.ResponseModel;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value="/car-rent/employees")

public class EmployeeController {
	
	public ResponseEntity<ResponseModel> getById(int id) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> getByCPF(String cpf) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> insert(Employee e) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> update(Employee e) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> delete(int id) throws SQLException {
		return null;
	}
	
	public ResponseEntity<ResponseModel> getByName(String name) throws SQLException {
		return null;
	}
}
