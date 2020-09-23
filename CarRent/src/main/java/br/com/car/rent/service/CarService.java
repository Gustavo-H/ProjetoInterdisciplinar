package br.com.car.rent.service;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.CarDAO;
import br.com.car.rent.model.Car;

public class CarService {

	private CarDAO dao = new CarDAO();

	public void insert(Car car, JdbcTemplate jdbc) {
		dao.insert(car, jdbc);
	}
	
	public Car getById(Integer carId, JdbcTemplate jdbc) {
		return dao.getById(carId, jdbc);
	}
}
