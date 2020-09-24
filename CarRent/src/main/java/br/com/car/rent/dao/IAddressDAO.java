package br.com.car.rent.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Address;

public interface IAddressDAO {
	public Integer insert(Address a, JdbcTemplate jdbc);	
	public Address getById(Integer id, JdbcTemplate jdbc);
	public void update(Address a, JdbcTemplate jdbc);
}
