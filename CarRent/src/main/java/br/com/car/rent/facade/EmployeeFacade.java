package br.com.car.rent.facade;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.DAOFactory;
import br.com.car.rent.model.Employee;
import br.com.car.rent.service.EmployeeService;

public class EmployeeFacade {
	
	private static EmployeeService employeeService = new EmployeeService();

	public static void insert(Employee employee) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			employeeService.insert(employee, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void update(Employee employee) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			employeeService.update(employee, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void delete(Employee employee) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		employeeService.delete(employee, jdbc);
	}

	public static Employee getById(Integer employeeId) throws SQLException {
		Employee ret = null;
		JdbcTemplate jdbc = DAOFactory.getConnection();
		ret = employeeService.getById(employeeId, jdbc);
		return ret;
	}

	public static Employee getByCPF(String cpf) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return employeeService.getByCPF(cpf, jdbc);
	}

	public static List<Employee> getByName(String name) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return employeeService.getByName(name, jdbc);
	}
	
	public static List<Employee> getAll() throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return employeeService.getAll(jdbc);
	}
}
