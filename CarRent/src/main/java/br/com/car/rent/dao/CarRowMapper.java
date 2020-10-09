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
					rs.getInt("color"), rs.getInt("group_id"), rs.getInt("year"), rs.getDouble("rent_price")));
		}
		return listCar;
	}

	public Car mapRow(SqlRowSet rs) {

		if (rs.next())
			return new Car(rs.getInt("id"), rs.getString("car_plate"), rs.getString("model"), rs.getInt("brand"),
					rs.getInt("color"), rs.getInt("group_id"), rs.getInt("year"), rs.getDouble("rent_price"));
		else
			return new Car();
	}
}
