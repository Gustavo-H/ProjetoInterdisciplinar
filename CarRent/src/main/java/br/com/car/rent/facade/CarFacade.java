package br.com.car.rent.facade;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.DAOFactory;
import br.com.car.rent.model.Car;
import br.com.car.rent.service.CarService;

public class CarFacade {
	
	private static CarService carService = new CarService();
	
	public static void insert(Car car) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			carService.insert(car, jdbc);			
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static Car getById(Integer carId) throws SQLException {
		Car ret = null;
		JdbcTemplate jdbc = DAOFactory.getConnection();
		ret = carService.getById(carId, jdbc);
		return ret;
	}
	

}
