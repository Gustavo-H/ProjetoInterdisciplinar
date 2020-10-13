package br.com.car.rent.facade;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.DAOFactory;
import br.com.car.rent.model.User;
import br.com.car.rent.service.UserService;

public class UserFacade {

	private static UserService userService = new UserService();
	
	public static void insert(User user) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			userService.insert(user, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void update(User user) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			userService.update(user, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void delete(User user) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			userService.delete(user, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static User getById(Integer userId) throws SQLException {
		User ret = null;
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			ret = userService.getById(userId, jdbc);
			return ret;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static User checkLogin(User user) throws SQLException {		
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return userService.checkLogin(user, jdbc);
		} catch (Exception e) {
			return new User();
		}
	}
	
	public static User getByLogin(String name) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return userService.getByLogin(name, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static List<User> getByName(String name) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return userService.getByName(name, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static List<User> getAll() throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return userService.getAll(jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}
