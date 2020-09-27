package br.com.car.rent.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.RentalDAO;
import br.com.car.rent.model.Rental;

public class RentalService {
	
	private RentalDAO dao = new RentalDAO();
	
	public void insert(Rental rental, JdbcTemplate jdbc) {
		dao.insert(rental, jdbc);
	}
	
	public void update(Rental rental, JdbcTemplate jdbc) {
		dao.update(rental, jdbc);
	}
		
	public Rental getById(Integer rentalId, JdbcTemplate jdbc) {
		return dao.getById(rentalId, jdbc);
	}
		
	public List<Rental> getByEmployee(Integer id, JdbcTemplate jdbc) {
		return dao.getByEmployee(id, jdbc);
	}
	
	public List<Rental> getByClient(Integer id, JdbcTemplate jdbc) {
			return dao.getByClient(id, jdbc);
	}
	
	public List<Rental> getByCar(Integer id, JdbcTemplate jdbc) {
		return dao.getByCar(id, jdbc);
}
}
