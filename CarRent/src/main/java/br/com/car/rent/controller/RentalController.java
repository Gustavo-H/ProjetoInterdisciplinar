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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.car.rent.facade.RentalFacade;
import br.com.car.rent.model.ExceptionModel;
import br.com.car.rent.model.GetResponseModel;
import br.com.car.rent.model.HomePage;
import br.com.car.rent.model.Rental;
import br.com.car.rent.model.RentalDTO;
import br.com.car.rent.model.ResponseModel;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/car-rent/rents")

public class RentalController {
		
	@PostMapping
	public ResponseEntity<ResponseModel> insert(@RequestBody @Valid Rental rental) throws Exception {
		RentalFacade.insert(rental);
		HttpStatus status = HttpStatus.CREATED;
		ResponseModel response = new ResponseModel(status.value(), "Rental Successfully inserted !");
		return new ResponseEntity<>(response, status);		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<GetResponseModel<Rental>> getById(@PathVariable("id") @NotBlank(message="id is required") Integer rentalId) throws SQLException {
		Rental rental = RentalFacade.getById(rentalId);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<Rental> response = new GetResponseModel<>(status.value(), "Rental successfully obtained !", rental);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/return/{id}")
	public ResponseEntity<GetResponseModel<Rental>> setReturnDate(@PathVariable("id") @NotBlank(message="id is required") Integer rentalId) throws SQLException {
		RentalFacade.setReturnDate(rentalId);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<Rental> response = new GetResponseModel<>(status.value(), "Rental successfully obtained !", new Rental());
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/homepage")
	public ResponseEntity<GetResponseModel<HomePage>> getHomePageContent() throws SQLException {
		HomePage home = RentalFacade.getHomePageContent();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<HomePage> response = new GetResponseModel<>(status.value(), "Rental successfully obtained !", home);
		return new ResponseEntity<>(response, status);
	}
		
	@GetMapping(path="/employee/{id}")
	public ResponseEntity<GetResponseModel<List<Rental>>> getByEmployee(@PathVariable("id") Integer id) throws SQLException {
		List<Rental> listRental = RentalFacade.getByEmployee(id);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Rental>> response = new GetResponseModel<>(status.value(), "Rents successfully obtained !", listRental);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/open")
	public ResponseEntity<GetResponseModel<List<RentalDTO>>> getOpen() throws SQLException {
		List<RentalDTO> listRental = RentalFacade.getOpen();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<RentalDTO>> response = new GetResponseModel<>(status.value(), "Rents successfully obtained !", listRental);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/closed")
	public ResponseEntity<GetResponseModel<List<RentalDTO>>> getClosed() throws SQLException {
		List<RentalDTO> listRental = RentalFacade.getClosed();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<RentalDTO>> response = new GetResponseModel<>(status.value(), "Rents successfully obtained !", listRental);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/client/{id}")
	public ResponseEntity<GetResponseModel<List<Rental>>> getByClient(@PathVariable("id") Integer id) throws SQLException {
		List<Rental> listRental = RentalFacade.getByClient(id);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Rental>> response = new GetResponseModel<>(status.value(), "Rents successfully obtained !", listRental);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/car/{id}")
	public ResponseEntity<GetResponseModel<List<Rental>>> getByCar(@PathVariable("id") Integer id) throws SQLException {
		List<Rental> listRental = RentalFacade.getByCar(id);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Rental>> response = new GetResponseModel<>(status.value(), "Rents successfully obtained !", listRental);
		return new ResponseEntity<>(response, status);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<ResponseModel> update(@RequestBody @Valid Rental rental) throws Exception {
		RentalFacade.update(rental);
		HttpStatus status = HttpStatus.OK;
		ResponseModel response = new ResponseModel(status.value(), "Rental Successfully updated !");
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
