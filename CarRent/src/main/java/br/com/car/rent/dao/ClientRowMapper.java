package br.com.car.rent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import br.com.car.rent.model.Address;
import br.com.car.rent.model.Client;

public class ClientRowMapper implements ResultSetExtractor<List<Client>> {

	AddressDAO addressDAO = new AddressDAO();
	
	@Override
	public List<Client> extractData(ResultSet rs) throws SQLException {
		List<Client> listClient = new ArrayList<>();
		while (rs.next()) {
			listClient.add(new Client(rs.getInt("id"), rs.getString("name"), rs.getString("cpf"), rs.getString("rg"),
					rs.getString("birthday"), getAddress(rs.getInt("address")), rs.getString("contact"), rs.getString("email")));
		}
		return listClient;
	}

	public Client mapRow(ResultSet rs) throws SQLException {
		Client client = null;
		while (rs.next()) {
			client = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("cpf"), rs.getString("rg"),
					rs.getString("birthday"), getAddress(rs.getInt("address")), rs.getString("contact"), rs.getString("email"));
		}
		return client;
	}

	public Client mapRow(SqlRowSet rs) throws InvalidResultSetAccessException, SQLException {
		rs.next();
		return new Client(rs.getInt("id"), rs.getString("name"), rs.getString("cpf"), rs.getString("rg"),
				rs.getString("birthday"), getAddress(rs.getInt("address")), rs.getString("contact"), rs.getString("email"));
	}
	
	private Address getAddress(Integer id) throws SQLException {
		AddressDAO addressDAO = new AddressDAO();
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return addressDAO.getById(id, jdbc);
	}
}
