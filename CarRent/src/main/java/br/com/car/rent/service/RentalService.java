package br.com.car.rent.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.CarDAO;
import br.com.car.rent.dao.ClientDAO;
import br.com.car.rent.dao.DAOFactory;
import br.com.car.rent.dao.EmployeeDAO;
import br.com.car.rent.dao.RentalDAO;
import br.com.car.rent.model.Car;
import br.com.car.rent.model.Client;
import br.com.car.rent.model.Employee;
import br.com.car.rent.model.Rental;
import br.com.car.rent.model.RentalDTO;

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
	
	public void setReturnDate(Integer rentalId, JdbcTemplate jdbc) {
		dao.setReturnDate(rentalId, jdbc);
	}

	public List<Rental> getByEmployee(Integer id, JdbcTemplate jdbc) {
		return dao.getByEmployee(id, jdbc);
	}

	public List<RentalDTO> getOpen() throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		List<RentalDTO> dtoList = new ArrayList<>();
		List<Rental> list = dao.getOpen(jdbc);

		list.forEach(item -> {
			try {
				dtoList.add(rentalDtoParse(item));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return dtoList;
	}

	public List<RentalDTO> getClosed() throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		List<RentalDTO> dtoList = new ArrayList<>();
		List<Rental> list = dao.getClosed(jdbc);

		list.forEach(item -> {
			try {
				dtoList.add(rentalDtoParse(item));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return dtoList;
	}

	public List<Rental> getByClient(Integer id, JdbcTemplate jdbc) {
		return dao.getByClient(id, jdbc);
	}

	public List<Rental> getByCar(Integer id, JdbcTemplate jdbc) {
		return dao.getByCar(id, jdbc);
	}
	
	private RentalDTO rentalDtoParse(Rental item) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		ClientDAO clientDAO = new ClientDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		CarDAO carDAO = new CarDAO();
		
		return new RentalDTO(clientDAO.getById(item.getClientId(), jdbc),
				employeeDAO.getById(item.getEmployeeId(), jdbc), carDAO.getById(item.getCarId(), jdbc), item);		
	}
}
