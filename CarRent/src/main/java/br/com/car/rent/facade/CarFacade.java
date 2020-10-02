package br.com.car.rent.facade;

import java.sql.SQLException;
import java.util.List;

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
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void update(Car car) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			carService.update(car, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void delete(Car car) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			carService.delete(car, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static Car getById(Integer carId) throws SQLException {
		Car ret = null;
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			ret = carService.getById(carId, jdbc);
			return ret;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static List<Car> getByGroup(Integer groupId) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return carService.getByGroup(groupId, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static List<Car> getAll() throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return carService.getAll(jdbc);

		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static Car getByCarPlate(String carPlate) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return carService.getByCarPlate(carPlate, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

}
