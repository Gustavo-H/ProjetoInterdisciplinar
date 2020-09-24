package br.com.car.rent.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Car;

public class CarDAO implements ICarDAO {

	@Override
	public Car getById(Integer carId, JdbcTemplate jdbc) {
		CarRowMapper mapper = new CarRowMapper();
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM CAR WHERE car.id = ?",carId));
	}

	@Override
	public void delete(Car c, JdbcTemplate jdbc) {
		jdbc.update("UPDATE CAR SET is_deleted=1, deleted_date=CURRENT_TIMESTAMP, deleted_by=? WHERE car.id=?",
				c.getDeletedBy(),
				c.getId());	
	}
	
	@Override
	public void insert(Car c, JdbcTemplate jdbc) {
		jdbc.update("INSERT INTO CAR(car_plate, model, brand, color, group_id, year) VALUES(?, ?, ?, ?, ?, ?)", 
				c.getCarPlate(),
				c.getModel(),
				c.getBrand(),
				c.getColor(),
				c.getGroupId(),
				c.getYear());
	}

	@Override
	public void update(Car c, JdbcTemplate jdbc) {
		jdbc.update("UPDATE CAR SET car_plate=?, model=?, brand=?, color=?, group_id=?, year=? WHERE car.id=?", 
				c.getCarPlate(),
				c.getModel(),
				c.getBrand(),
				c.getColor(),
				c.getGroupId(),
				c.getYear(),
				c.getId());	
	}

	@Override
	public Car getByCarPlate(String carPlate, JdbcTemplate jdbc) {
		CarRowMapper mapper = new CarRowMapper();
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM CAR WHERE car.car_plate = ?",carPlate));
	}

	@Override
	public List<Car> getByGroup(Integer groupId, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM CAR WHERE car.group_id = " + groupId + " AND is_deleted=0", new CarRowMapper());
	}
}
