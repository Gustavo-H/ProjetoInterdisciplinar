package br.com.car.rent.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;



import br.com.car.rent.model.Car;

public class CarDAO implements ICarDAO {

	@Override
	public Car getById(Integer carId, JdbcTemplate jdbc) {		
		Object ret = jdbc.query("SELECT * FROM CAR WHERE car.id = " + carId, new CarRowMapper());
		return (Car) ret;
	}

	@Override
	public void deleteById(Integer carId, JdbcTemplate jdbc) {
		jdbc.update("DELETE FROM CAR WHERE car.id = " + carId);
	}
	
	@Override
	public void insert(Car c, JdbcTemplate jdbc) {
		jdbc.update("INSERT INTO CAR(carPlate, model, brand, color, groupId, year) VALUES(?, ?, ?, ?, ?, ?)", 
				c.getCarPlate(),
				c.getModel(),
				c.getBrand(),
				c.getColor(),
				c.getGroupId(),
				c.getYear());
	}

	@Override
	public void update(Car c, JdbcTemplate jdbc) {
		jdbc.update("UPDATE CAR SET carPlate=?, model=?, brand=?, color=?, groupId=?, year=? WHERE car.id=?", 
				c.getCarPlate(),
				c.getModel(),
				c.getBrand(),
				c.getColor(),
				c.getGroupId(),
				c.getYear(),
				c.getId());	
	}

	@Override
	public List<Car> getByCarPlate(String carPlates, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM CAR WHERE car.car_plate = " + carPlates, new CarRowMapper());		 		
	}

	@Override
	public List<Car> getByGroup(String carPlates, JdbcTemplate jdbc) {
		// TODO Auto-generated method stub
		return null;
	}

}
