package br.com.car.rent.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.User;

public class UserDAO implements IUserDAO {

	@Override
	public User getById(Integer id, JdbcTemplate jdbc) {
		UserRowMapper mapper = new UserRowMapper();
		try {
			return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM USER WHERE USER.id = ?", id));
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
	public void delete(User u, JdbcTemplate jdbc) {
		jdbc.update("UPDATE USER SET is_deleted=1, deleted_date=CURRENT_TIMESTAMP, deleted_by=? WHERE USER.id=?",
				u.getDeletedBy(), u.getId());
	}

	@Override
	public void insert(User u, JdbcTemplate jdbc) {
		jdbc.update("INSERT INTO USER(name, login, password, owner_id, type) VALUES(?, ?, ?, ?, ?)", u.getName(),
				u.getLogin(), u.getPassword(), u.getOwnerId(), u.getType());
	}

	@Override
	public void update(User u, JdbcTemplate jdbc) {
		jdbc.update("UPDATE USER SET name=?, login=?, password=?, owner_id=?, type=? WHERE USER.id=?", u.getName(),
				u.getLogin(), u.getPassword(), u.getOwnerId(), u.getType(), u.getId());
	}

	@Override
	public User checkLogin(User u, JdbcTemplate jdbc) {
		UserRowMapper mapper = new UserRowMapper();
		try {
			return mapper.mapRow(jdbc.queryForRowSet(
					"SELECT * FROM USER WHERE USER.login = ? AND USER.password=? AND USER.is_deleted=0;", u.getLogin(),
					u.getPassword()));
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
	public List<User> getByName(String name, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM USER WHERE USER.name LIKE '%" + name + "%' AND USER.is_deleted=0;",
				new UserRowMapper());
	}
	
	@Override
	public List<User> getAll(JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM USER WHERE USER.is_deleted=0;",
				new UserRowMapper());
	}

	@Override
	public User getByLogin(String login, JdbcTemplate jdbc) {
		UserRowMapper mapper = new UserRowMapper();
		try {
			return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM USER WHERE USER.login = ?;", login));
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
}