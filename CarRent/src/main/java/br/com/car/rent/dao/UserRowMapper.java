package br.com.car.rent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import br.com.car.rent.model.User;

public class UserRowMapper implements ResultSetExtractor<List<User>> {
	@Override
	public List<User> extractData(ResultSet rs) throws SQLException {
		List<User> listUser = new ArrayList<>();
		while (rs.next()) {
			listUser.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"),
					rs.getString("password"), rs.getInt("owner_id"), rs.getInt("type")));
		}
		return listUser;
	}

	public User mapRow(SqlRowSet rs) throws InvalidResultSetAccessException, SQLException {
		rs.next();
		return new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"),
				rs.getString("password"), rs.getInt("owner_id"), rs.getInt("type"));
	}
}
