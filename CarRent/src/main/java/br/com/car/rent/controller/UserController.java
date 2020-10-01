package br.com.car.rent.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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

import br.com.car.rent.facade.UserFacade;
import br.com.car.rent.model.User;
import br.com.car.rent.model.ExceptionModel;
import br.com.car.rent.model.GetResponseModel;
import br.com.car.rent.model.ResponseModel;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/car-rent/users")

public class UserController {
	
	@PostMapping
	public ResponseEntity<ResponseModel> insert(@RequestBody @Valid User user) throws Exception {
		UserFacade.insert(user);
		HttpStatus status = HttpStatus.CREATED;
		ResponseModel response = new ResponseModel(status.value(), "User Successfully inserted !");
		return new ResponseEntity<>(response, status);		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<GetResponseModel<User>> getById(@PathVariable("id") @NotBlank(message="id is required") Integer userId) throws SQLException {
		User user = UserFacade.getById(userId);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<User> response = new GetResponseModel<>(status.value(), "User successfully obtained !", user);
		return new ResponseEntity<>(response, status);
	}
		
	@GetMapping(path="/name/{name}")
	public ResponseEntity<GetResponseModel<List<User>>> getByName(@PathVariable("name") String name) throws SQLException {
		List<User> listUser = UserFacade.getByName(name);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<User>> response = new GetResponseModel<>(status.value(), "Users successfully obtained !", listUser);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/login/{login}")
	public ResponseEntity<GetResponseModel<List<User>>> getByLogin(@PathVariable("login") String login) throws SQLException {
		List<User> listUser = UserFacade.getByLogin(login);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<User>> response = new GetResponseModel<>(status.value(), "Users successfully obtained !", listUser);
		return new ResponseEntity<>(response, status);
	}
	
	@PatchMapping(path="/check")
	public ResponseEntity<GetResponseModel<User>> checkLogin(@RequestBody @Valid User userToCheck) throws SQLException {
		User user = UserFacade.checkLogin(userToCheck);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<User> response = new GetResponseModel<>(status.value(), "User successfully checked !", user);
		return new ResponseEntity<>(response, status);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<ResponseModel> update(@RequestBody @Valid User user) throws Exception {
		UserFacade.update(user);
		HttpStatus status = HttpStatus.OK;
		ResponseModel response = new ResponseModel(status.value(), "User Successfully updated !");
		return new ResponseEntity<>(response, status);		
	}

	@PatchMapping(path="/delete")
	public ResponseEntity<ResponseModel> delete(@RequestBody @Valid User user) throws Exception {
		UserFacade.delete(user);
		HttpStatus status = HttpStatus.OK;
		ResponseModel response = new ResponseModel(status.value(), "User Successfully Deleted !");
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
