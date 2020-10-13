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

import br.com.car.rent.facade.CarFacade;
import br.com.car.rent.model.Car;
import br.com.car.rent.model.CarDTO;
import br.com.car.rent.model.ExceptionModel;
import br.com.car.rent.model.GetResponseModel;
import br.com.car.rent.model.ResponseModel;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/car-rent/cars")

public class CarController {

	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@PostMapping
	public ResponseEntity<ResponseModel> insert(@RequestBody @Valid Car car) throws Exception {
		CarFacade.insert(car);
		HttpStatus status = HttpStatus.CREATED;
		ResponseModel response = new ResponseModel(status.value(), "Car Successfully inserted !");
		return new ResponseEntity<>(response, status);		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<GetResponseModel<CarDTO>> getById(@PathVariable("id") @NotBlank(message="id is required") Integer carId) throws SQLException {
		CarDTO car = CarFacade.getById(carId);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<CarDTO> response = new GetResponseModel<>(status.value(), "Car successfully obtained !", car);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/available")
	public ResponseEntity<GetResponseModel<List<CarDTO>>> getAvailable() throws SQLException {
		List<CarDTO> listCar = CarFacade.getAvailable();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<CarDTO>> response = new GetResponseModel<>(status.value(), "Car successfully obtained !", listCar);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<GetResponseModel<List<CarDTO>>> getAll() throws SQLException {
		List<CarDTO> listCar = CarFacade.getAll();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<CarDTO>> response = new GetResponseModel<>(status.value(), "Car successfully obtained !", listCar);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/all/edit")
	public ResponseEntity<GetResponseModel<List<Car>>> getAllEdit() throws SQLException {
		List<Car> listCar = CarFacade.getAllEdit();
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<Car>> response = new GetResponseModel<>(status.value(), "Car successfully obtained !", listCar);
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/plate/{carPlate}")
	public ResponseEntity<GetResponseModel<CarDTO>> getByCarPlate(@PathVariable("carPlate") String carPlate) throws SQLException {
		CarDTO car = CarFacade.getByCarPlate(carPlate);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<CarDTO> response = new GetResponseModel<>(status.value(), "Car successfully obtained !", car);
		logger.info("CarController.get() - Exiting");
		return new ResponseEntity<>(response, status);
	}
	
	@GetMapping(path="/group/{groupId}")
	public ResponseEntity<GetResponseModel<List<CarDTO>>> getByGroup(@PathVariable("groupId") @NotBlank(message="id is required") Integer groupId) throws SQLException {
		List<CarDTO> listCar = CarFacade.getByGroup(groupId);
		HttpStatus status = HttpStatus.OK;
		GetResponseModel<List<CarDTO>> response = new GetResponseModel<>(status.value(), "Car successfully obtained !", listCar);
		return new ResponseEntity<>(response, status);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<ResponseModel> update(@RequestBody @Valid Car car) throws Exception {
		CarFacade.update(car);
		HttpStatus status = HttpStatus.CREATED;
		ResponseModel response = new ResponseModel(status.value(), "Car Successfully updated !");
		return new ResponseEntity<>(response, status);		
	}

	@PatchMapping(path="/delete")
	public ResponseEntity<ResponseModel> delete(@RequestBody @Valid Car car) throws Exception {
		CarFacade.delete(car);
		HttpStatus status = HttpStatus.CREATED;
		ResponseModel response = new ResponseModel(status.value(), "Car Successfully Deleted !");
		return new ResponseEntity<>(response, status);		
	}

	@GetMapping(value = "/ping")
	public ResponseEntity<String> pingApplication() {
		return new ResponseEntity<>("Hello World !", HttpStatus.OK);
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
