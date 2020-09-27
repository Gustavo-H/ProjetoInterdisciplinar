package br.com.car.rent.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.User;

public interface IUserDAO {
	public User getById(Integer id, JdbcTemplate jdbc);
	public User checkLogin(User user, JdbcTemplate jdbc);
	public void delete(User user, JdbcTemplate jdbc);
	public void insert(User user, JdbcTemplate jdbc);	
	public void update(User user, JdbcTemplate jdbc);
	public List<User> getByLogin(String login, JdbcTemplate jdbc);
	public List<User> getByName(String name, JdbcTemplate jdbc);
}
