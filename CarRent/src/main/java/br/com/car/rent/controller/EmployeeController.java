package br.com.car.rent.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.car.rent.facade.EmployeeFacade;
import br.com.car.rent.model.Employee;
import br.com.car.rent.model.ExceptionModel;
import br.com.car.rent.model.GetResponseModel;
import br.com.car.rent.model.ResponseModel;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/car-rent/employees")

public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@PostMapping
	public ResponseEntity<ResponseModel> insert(@RequestBody @Valid Employee employee) throws Exception {
		EmployeeFacade.insert(employee);
		HttpStatus status = HttpStatus.CREATED;
		ResponseModel response = new ResponseModel(status.value(), "Employee Successfully inserted !");
		return new ResponseEntity<>(response, status);		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<GetResponseModel<Employee>> getById(@PathVariable("id") @NotBlank(message="id is required") Integer employeeId) throws SQLException {
		Employee employee = EmployeeFacade.getById(employeeId);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<Employee> response = new GetResponseModel<>(status.value(), "Employee successfully obtained !", employee);
		return new ResponseEntity<>(response, status);
	}
	
	
	@GetMapping(path="/cpf/{cpf}")
	public ResponseEntity<GetResponseModel<Employee>> getByCpf(@PathVariable("cpf") String cpf) throws SQLException {
		Employee employee = EmployeeFacade.getByCPF(cpf);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<Employee> response = new GetResponseModel<>(status.value(), "Employee successfully obtained !", employee);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/name/{name}")
	public ResponseEntity<GetResponseModel<List<Employee>>> getByName(@PathVariable("name") String name) throws SQLException {
		List<Employee> listEmployee = EmployeeFacade.getByName(name);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Employee>> response = new GetResponseModel<>(status.value(), "Employees successfully obtained !", listEmployee);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<GetResponseModel<List<Employee>>> getAll() throws SQLException {
		List<Employee> listEmployee = EmployeeFacade.getAll();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Employee>> response = new GetResponseModel<>(status.value(), "Employees successfully obtained !", listEmployee);
		return new ResponseEntity<>(response, status);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<ResponseModel> update(@RequestBody @Valid Employee employee) throws Exception {
		EmployeeFacade.update(employee);
		HttpStatus status = HttpStatus.OK;
		ResponseModel response = new ResponseModel(status.value(), "Employee Successfully updated !");
		return new ResponseEntity<>(response, status);		
	}

	@PatchMapping(path="/delete")
	public ResponseEntity<ResponseModel> delete(@RequestBody @Valid Employee employee) throws Exception {
		EmployeeFacade.delete(employee);
		HttpStatus status = HttpStatus.OK;
		ResponseModel response = new ResponseModel(status.value(), "Employee Successfully Deleted !");
		return new ResponseEntity<>(response, status);		
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ExceptionModel> handleSQLException(SQLException e) {
		ExceptionModel exceptionResponse = new ExceptionModel();
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionModel> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		ExceptionModel exceptionResponse = new ExceptionModel();
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}	
}
