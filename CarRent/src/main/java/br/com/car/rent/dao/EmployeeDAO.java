package br.com.car.rent.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Employee;

public class EmployeeDAO implements IEmployeeDAO{

	@Override
	public Employee getById(Integer id, JdbcTemplate jdbc) {
		EmployeeRowMapper mapper = new EmployeeRowMapper();
		try {
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM EMPLOYEE WHERE EMPLOYEE.id = ?", id));
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
	public void delete(Employee employee, JdbcTemplate jdbc) {
		jdbc.update("UPDATE EMPLOYEE SET is_deleted=1, deleted_date=CURRENT_TIMESTAMP, deleted_by=? WHERE EMPLOYEE.id=?",
				employee.getDeletedBy(),
				employee.getId());		
	}

	@Override
	public void insert(Employee e, JdbcTemplate jdbc) {
		jdbc.update("INSERT INTO EMPLOYEE(name, serial, cpf, role) VALUES(?, ?, ?, ?)",
				e.getName(), 
				e.getSerial(), 
				e.getCpf(), 
				e.getRole());		
	}

	@Override
	public void update(Employee e, JdbcTemplate jdbc) {
		jdbc.update("UPDATE EMPLOYEE SET name=?, serial=?, cpf=?, role=? WHERE id=?",
				e.getName(), 
				e.getSerial(), 
				e.getCpf(), 
				e.getRole(),
				e.getId());
	}

	@Override
	public Employee getByCPF(String cpf, JdbcTemplate jdbc) {
		EmployeeRowMapper mapper = new EmployeeRowMapper();
		try {
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM EMPLOYEE WHERE employee.cpf = ?", cpf));
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
	public List<Employee> getByName(String name, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM EMPLOYEE WHERE EMPLOYEE.name like '%" + name + "%' AND EMPLOYEE.is_deleted=0;", new EmployeeRowMapper());
	}

}
