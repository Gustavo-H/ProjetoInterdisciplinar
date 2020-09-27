package br.com.car.rent.facade;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.DAOFactory;
import br.com.car.rent.model.Rental;
import br.com.car.rent.service.RentalService;

public class RentalFacade {
	
	private static RentalService rentalService = new RentalService();
	
	public static void insert(Rental rental) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			rentalService.insert(rental, jdbc);			
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Rental rental) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			rentalService.update(rental, jdbc);		
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
			
	public static Rental getById(Integer rentalId) throws SQLException {
		Rental ret = null;
		try {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		ret = rentalService.getById(rentalId, jdbc);
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
		return ret;
	}
		
	public static List<Rental> getByEmployee(Integer id) throws SQLException {
		try {
		JdbcTemplate jdbc = DAOFactory.getConnection();
			return rentalService.getByEmployee(id, jdbc);
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static  List<Rental> getByClient(Integer id) throws SQLException {
		try {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return rentalService.getByClient(id, jdbc);
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static  List<Rental> getByCar(Integer id) throws SQLException {
		try {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return rentalService.getByCar(id, jdbc);
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
}
