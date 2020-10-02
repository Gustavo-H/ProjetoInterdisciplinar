package br.com.car.rent.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Employee;

public interface IEmployeeDAO {
	public Employee getById(Integer id, JdbcTemplate jdbc) throws InvalidResultSetAccessException, DataAccessException, SQLException;
	public void delete(Employee e, JdbcTemplate jdbc);
	public void insert(Employee e, JdbcTemplate jdbc);	
	public void update(Employee e, JdbcTemplate jdbc);
	public Employee getByCPF(String cpf, JdbcTemplate jdbc);
	public List<Employee> getByName(String name, JdbcTemplate jdbc);
	public List<Employee> getAll(JdbcTemplate jdbc);
}
