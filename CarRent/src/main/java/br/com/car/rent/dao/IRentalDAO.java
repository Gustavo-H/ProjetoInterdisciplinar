package br.com.car.rent.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Rental;

public interface IRentalDAO {
	public Rental getById(Integer id, JdbcTemplate jdbc);
	public void insert(Rental rental, JdbcTemplate jdbc);	
	public void update(Rental rental, JdbcTemplate jdbc);
	public List<Rental> getByEmployee(Integer employeeId, JdbcTemplate jdbc);
	public List<Rental> getByClient(Integer clientId, JdbcTemplate jdbc);
	public List<Rental> getByCar(Integer carId, JdbcTemplate jdbc);
	public List<Rental> getOpen(JdbcTemplate jdbc);
	public List<Rental> getClosed(JdbcTemplate jdbc);
	public void setReturnDate(Integer id, JdbcTemplate jdbc);
}
