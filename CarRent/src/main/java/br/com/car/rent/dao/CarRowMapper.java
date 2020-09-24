package br.com.car.rent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import br.com.car.rent.model.Car;

public class CarRowMapper implements ResultSetExtractor<List<Car>> {

	@Override
	public List<Car> extractData(ResultSet rs) throws SQLException {
		List<Car> listCar = new ArrayList<>();
		while (rs.next()) {
			listCar.add(new Car(rs.getInt("id"), rs.getString("car_plate"), rs.getString("model"), rs.getInt("brand"),
					rs.getInt("color"), rs.getInt("group_id"), rs.getInt("year")));
		}
		return listCar;
	}

	public Car mapRow(ResultSet rs) throws SQLException {
		Car car = null;
		while (rs.next()) {
			car = new Car(rs.getInt("id"), rs.getString("car_plate"), rs.getString("model"), rs.getInt("brand"),
					rs.getInt("color"), rs.getInt("group_id"), rs.getInt("year"));
		}
		return car;
	}

	public Car mapRow(SqlRowSet rs) {
		rs.next();
		return new Car(rs.getInt("id"), rs.getString("car_plate"), rs.getString("model"), rs.getInt("brand"),
					rs.getInt("color"), rs.getInt("group_id"), rs.getInt("year"));
	}
}
