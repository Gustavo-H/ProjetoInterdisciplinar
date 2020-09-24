package br.com.car.rent.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Employee;

public class EmployeeDAO implements IEmployeeDAO{

	@Override
	public Employee getById(Integer id, JdbcTemplate jdbc) {
		EmployeeRowMapper mapper = new EmployeeRowMapper();
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM employee WHERE employee.id = ?", id));
	}

	@Override
	public void deleteById(Integer id, JdbcTemplate jdbc) {
		jdbc.update("UPDATE employee set is_deleted=1,  WHERE car.id = " + id);		
	}

	@Override
	public void insert(Employee e, JdbcTemplate jdbc) {
		jdbc.update("INSERT INTO employee(name, serial, cpf, role) VALUES(?, ?, ?, ?)",
				e.getName(), 
				e.getSerial(), 
				e.getCpf(), 
				e.getRole());
		
	}

	@Override
	public void update(Employee e, JdbcTemplate jdbc) {
		jdbc.update("UPDATE employee SET name=?, serial=?, cpf=?, role=? WHERE id=?",
				e.getName(), 
				e.getSerial(), 
				e.getCpf(), 
				e.getRole(),
				e.getId());
	}

	@Override
	public Employee getByCPF(String cpf, JdbcTemplate jdbc) {
		EmployeeRowMapper mapper = new EmployeeRowMapper();
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM employee WHERE employee.cpf = ?", cpf));
	}

	@Override
	public List<Employee> getByName(String name, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM employee WHERE employee.name like '%" + name + "%';" + name, new EmployeeRowMapper());
	}

}
