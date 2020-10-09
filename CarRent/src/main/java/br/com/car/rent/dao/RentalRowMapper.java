package br.com.car.rent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import br.com.car.rent.model.Rental;

public class RentalRowMapper implements ResultSetExtractor<List<Rental>> {
	
	@Override
	public List<Rental> extractData(ResultSet rs) throws SQLException {
		List<Rental> listRental = new ArrayList<>();
		while (rs.next()) {
			listRental.add(new Rental(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("employee_id"),
					rs.getInt("car_id"), rs.getDouble("discount"), rs.getDouble("daily_cost"), rs.getString("date_withdrawal"),
					rs.getString("expected_return_date"), rs.getString("effective_return_date")));
		}
		return listRental;
	}

	public Rental mapRow(SqlRowSet rs) throws InvalidResultSetAccessException, SQLException {
		rs.next();
		return new Rental(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("employee_id"),
				rs.getInt("car_id"), rs.getDouble("discount"), rs.getDouble("daily_cost"), rs.getString("date_withdrawal"),
				rs.getString("expected_return_date"), rs.getString("effective_return_date"));
	}
}
