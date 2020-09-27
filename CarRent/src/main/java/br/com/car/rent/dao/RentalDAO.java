package br.com.car.rent.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Rental;

public class RentalDAO implements IRentalDAO {

	@Override
	public Rental getById(Integer id, JdbcTemplate jdbc) {
		RentalRowMapper mapper = new RentalRowMapper();
		try {
			return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM RENTAL WHERE RENTAL.id = ?", id));
		} catch (InvalidResultSetAccessException e) {
			e.printStackTrace();
			return null;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insert(Rental r, JdbcTemplate jdbc) {
		jdbc.update(
				"INSERT INTO RENTAL(client_id, employee_id, car_id, discount, date_withdrawal, "
						+ "expected_return_date, effective_return_date) VALUES(?, ?, ?, ?, ?, ?, ?)",
				r.getClientId(), r.getEmployeeId(), r.getCarId(), r.getDiscount(), r.getDateWithdrawal(), r.getExpectedReturnDate(),
				r.getEffectiveReturnDate());
	}

	@Override
	public void update(Rental r, JdbcTemplate jdbc) {
		jdbc.update(
				"UPDATE RENTAL SET client_id=?, employee_id=?, car_id=?, discount=?, date_withdrawal=?, "
						+ "expected_return_date=?, effective_return_date=? WHERE RENTAL.id=?",
						r.getClientId(), r.getEmployeeId(), r.getCarId(), r.getDiscount(), r.getDateWithdrawal(), r.getExpectedReturnDate(),
						r.getEffectiveReturnDate(), r.getId());
	}

	@Override
	public List<Rental> getByEmployee(Integer employeeId, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM RENTAL WHERE RENTAL.employee_id = " + employeeId, new RentalRowMapper());
	}

	@Override
	public List<Rental> getByClient(Integer clientId, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM RENTAL WHERE RENTAL.client_id = " + clientId, new RentalRowMapper());
	}

	@Override
	public List<Rental> getByCar(Integer carId, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM RENTAL WHERE RENTAL.car_id = " + carId, new RentalRowMapper());
	}
}