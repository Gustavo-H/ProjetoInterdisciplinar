package br.com.car.rent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import br.com.car.rent.model.Employee;

public class EmployeeRowMapper implements ResultSetExtractor<List<Employee>> {

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException {
		List<Employee> listEmployee = new ArrayList<>();
		while (rs.next()) {
			listEmployee.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("serial"),
					rs.getString("cpf"), rs.getInt("role")));
		}
		return listEmployee;
	}

	public Employee mapRow(ResultSet rs) throws SQLException {
		Employee e = null;
		while (rs.next()) {
			e = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("serial"), rs.getString("cpf"),
					rs.getInt("role"));
		}
		return e;
	}

	public Employee mapRow(SqlRowSet rs) {
		rs.next();
		return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("serial"), rs.getString("cpf"),
				rs.getInt("role"));
	}

}
