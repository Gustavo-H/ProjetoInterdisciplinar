package br.com.car.rent.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import br.com.car.rent.model.Address;

public class AddressDAO implements IAddressDAO {

	@Override
	public Integer insert(Address a, JdbcTemplate jdbc) {
		SqlRowSet rs = jdbc.queryForRowSet("CALL SP_INSERT_ADDRESS(?, ?, ?, ?, ?, ?); ", a.getStreet(), a.getNumber(),
				a.getNeighborhood(), a.getCity(), a.getState(), a.getComplement());
		rs.next();
		return rs.getInt("id");
	}

	@Override
	public Address getById(Integer id, JdbcTemplate jdbc) {
		Address address = new Address();
		SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM ADDRESS WHERE ADDRESS.id = ?", id);
		if (rs.next()) {
			address.setCity(rs.getString("city"));
			address.setComplement(rs.getString("complement"));
			address.setId(id);
			address.setNeighborhood(rs.getString("neighborhood"));
			address.setNumber(rs.getInt("number"));
			address.setState(rs.getString("state"));
			address.setStreet(rs.getString("street"));
		}
		return address;
	}

	@Override
	public void update(Address a, JdbcTemplate jdbc) {
		jdbc.update("UPDATE ADDRESS SET street=?, number=?, neighborhood=?, city=?, state=?, complement=? WHERE ADDRESS.id=?",
				a.getStreet(),
				a.getNumber(),
				a.getNeighborhood(),
				a.getCity(),
				a.getState(),
				a.getComplement(),
				a.getId());
	}
}
