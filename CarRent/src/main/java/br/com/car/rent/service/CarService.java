package br.com.car.rent.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.CarDAO;
import br.com.car.rent.model.Car;

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
	
	public Car getById(Integer carId, JdbcTemplate jdbc) {
		return dao.getById(carId, jdbc);
	}
	
	public List<Car> getByGroup(Integer groupId, JdbcTemplate jdbc) {
		return dao.getByGroup(groupId, jdbc);
	}
	
	public Car getByCarPlate(String carPlate, JdbcTemplate jdbc) {
		return dao.getByCarPlate(carPlate, jdbc);
	}
}
