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

import br.com.car.rent.facade.ClientFacade;
import br.com.car.rent.model.Client;
import br.com.car.rent.model.ExceptionModel;
import br.com.car.rent.model.GetResponseModel;
import br.com.car.rent.model.ResponseModel;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/car-rent/clients")

public class ClientController {

	@PostMapping
	public ResponseEntity<ResponseModel> insert(@RequestBody @Valid Client client) throws Exception {
		ClientFacade.insert(client);
		HttpStatus status = HttpStatus.CREATED;
		ResponseModel response = new ResponseModel(status.value(), "Client Successfully inserted !");
		return new ResponseEntity<>(response, status);		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<GetResponseModel<Client>> getById(@PathVariable("id") @NotBlank(message="id is required") Integer clientId) throws SQLException {
		Client client = ClientFacade.getById(clientId);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<Client> response = new GetResponseModel<>(status.value(), "Client successfully obtained !", client);
		return new ResponseEntity<>(response, status);
	}
	
	
	@GetMapping(path="/cpf/{cpf}")
	public ResponseEntity<GetResponseModel<Client>> getByCpf(@PathVariable("cpf") String cpf) throws SQLException {
		Client client = ClientFacade.getByCPF(cpf);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<Client> response = new GetResponseModel<>(status.value(), "Client successfully obtained !", client);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/name/{name}")
	public ResponseEntity<GetResponseModel<List<Client>>> getByName(@PathVariable("name") String name) throws SQLException {
		List<Client> listClient = ClientFacade.getByName(name);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Client>> response = new GetResponseModel<>(status.value(), "Clients successfully obtained !", listClient);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<GetResponseModel<List<Client>>> getAll() throws SQLException {
		List<Client> listClient = ClientFacade.getAll();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Client>> response = new GetResponseModel<>(status.value(), "Clients successfully obtained !", listClient);
		return new ResponseEntity<>(response, status);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<ResponseModel> update(@RequestBody @Valid Client client) throws Exception {
		ClientFacade.update(client);
		HttpStatus status = HttpStatus.OK;
		ResponseModel response = new ResponseModel(status.value(), "Client Successfully updated !");
		return new ResponseEntity<>(response, status);		
	}

	@PatchMapping(path="/delete")
	public ResponseEntity<ResponseModel> delete(@RequestBody @Valid Client client) throws Exception {
		ClientFacade.delete(client);
		HttpStatus status = HttpStatus.OK;
		ResponseModel response = new ResponseModel(status.value(), "Client Successfully Deleted !");
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
