package br.com.car.rent.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.EmployeeDAO;
import br.com.car.rent.model.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();

	public void insert(Employee employee, JdbcTemplate jdbc) {
		dao.insert(employee, jdbc);
	}

	public void update(Employee employee, JdbcTemplate jdbc) {
		dao.update(employee, jdbc);
	}

	public void delete(Employee employee, JdbcTemplate jdbc) {
		dao.delete(employee, jdbc);
	}

	public Employee getById(Integer employeeId, JdbcTemplate jdbc) {
		return dao.getById(employeeId, jdbc);
	}

	public Employee getByCPF(String cpf, JdbcTemplate jdbc) {
		return dao.getByCPF(cpf, jdbc);
	}

	public List<Employee> getByName(String name, JdbcTemplate jdbc) {
		if (name == null)
			name = "";
		return dao.getByName(name, jdbc);
	}
}
