package br.com.car.rent.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.UserDAO;
import br.com.car.rent.model.User;

public class UserService {
	
	private UserDAO dao = new UserDAO();
	
	public void insert(User user, JdbcTemplate jdbc) {
		dao.insert(user, jdbc);
	}
	
	public void update(User user, JdbcTemplate jdbc) {
		dao.update(user, jdbc);
	}
	
	public void delete(User user, JdbcTemplate jdbc) {
		dao.delete(user, jdbc);
	}
	
	public User getById(Integer userId, JdbcTemplate jdbc) {
		return dao.getById(userId, jdbc);
	}
	
	public User checkLogin(User user, JdbcTemplate jdbc) {
		return dao.checkLogin(user, jdbc);
	}
	
	public User getByLogin(String login, JdbcTemplate jdbc) {
		return dao.getByLogin(login, jdbc);
	}
	
	public List<User> getByName(String name, JdbcTemplate jdbc) {
		if(name == null)
			name = "";
		return dao.getByName(name, jdbc);
	}
	
	public List<User> getAll(JdbcTemplate jdbc) {	
		return dao.getAll(jdbc);
	}
}
