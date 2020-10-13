package br.com.car.rent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.CarDAO;
import br.com.car.rent.model.Car;
import br.com.car.rent.model.CarDTO;

public class CarService {

	private CarDAO dao = new CarDAO();

	public void insert(Car car, JdbcTemplate jdbc) {
		dao.insert(car, jdbc);
	}

	public void update(Car car, JdbcTemplate jdbc) {
		dao.update(car, jdbc);
	}

	public void delete(Car car, JdbcTemplate jdbc) {
		dao.delete(car, jdbc);
	}

	public CarDTO getById(Integer carId, JdbcTemplate jdbc) {
		Car car = dao.getById(carId, jdbc);
		return new CarDTO(car.getId(), car.getCarPlate(), car.getModel(), car.getBrand(), car.getColor(),
				car.getGroup(), car.getYear(), car.getRentPrice(), car.getIsRented());
	}

	public List<CarDTO> getByGroup(Integer groupId, JdbcTemplate jdbc) {
		List<Car> listCar = dao.getByGroup(groupId, jdbc);
		List<CarDTO> dto = new ArrayList<>();

		listCar.forEach(car -> dto.add(new CarDTO(car.getId(), car.getCarPlate(), car.getModel(), car.getBrand(),
				car.getColor(), car.getGroup(), car.getYear(), car.getRentPrice(), car.getIsRented())));
		return dto;
	}

	public List<CarDTO> getAll(JdbcTemplate jdbc) {
		List<Car> listCar = dao.getAll(jdbc);
		List<CarDTO> dto = new ArrayList<>();

		listCar.forEach(car -> dto.add(new CarDTO(car.getId(), car.getCarPlate(), car.getModel(), car.getBrand(),
				car.getColor(), car.getGroup(), car.getYear(), car.getRentPrice(), car.getIsRented())));
		return dto;
	}
		
	public List<Car> getAllEdit(JdbcTemplate jdbc) {
		return dao.getAll(jdbc);
	}
	
	public List<CarDTO> getAvailable(JdbcTemplate jdbc) {
		List<Car> listCar = dao.getAvailable(jdbc);
		List<CarDTO> dto = new ArrayList<>();

		listCar.forEach(car -> dto.add(new CarDTO(car.getId(), car.getCarPlate(), car.getModel(), car.getBrand(),
				car.getColor(), car.getGroup(), car.getYear(), car.getRentPrice(), car.getIsRented())));
		return dto;
	}

	public CarDTO getByCarPlate(String carPlate, JdbcTemplate jdbc) {
		Car car = dao.getByCarPlate(carPlate, jdbc);
		return new CarDTO(car.getId(), car.getCarPlate(), car.getModel(), car.getBrand(), car.getColor(),
				car.getGroup(), car.getYear(), car.getRentPrice(), car.getIsRented());
	}
}
