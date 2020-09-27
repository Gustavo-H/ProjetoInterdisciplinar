package br.com.car.rent.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import br.com.car.rent.model.Car;

public interface ICarDAO {
	public Car getById(Integer carId, JdbcTemplate jdbc);
	public List<Car> getAll(JdbcTemplate jdbc);
	public void delete(Car c, JdbcTemplate jdbc);
	public void insert(Car c, JdbcTemplate jdbc);
	public void update(Car c, JdbcTemplate jdbc);
	public Car getByCarPlate(String carPlates, JdbcTemplate jdbc);
	public List<Car> getByGroup(Integer groupID, JdbcTemplate jdbc);
}