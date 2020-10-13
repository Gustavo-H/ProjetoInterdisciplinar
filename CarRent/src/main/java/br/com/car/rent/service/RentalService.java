package br.com.car.rent.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.CarDAO;
import br.com.car.rent.dao.ClientDAO;
import br.com.car.rent.dao.DAOFactory;
import br.com.car.rent.dao.EmployeeDAO;
import br.com.car.rent.dao.RentalDAO;
import br.com.car.rent.facade.CarFacade;
import br.com.car.rent.facade.ClientFacade;
import br.com.car.rent.facade.EmployeeFacade;
import br.com.car.rent.facade.UserFacade;
import br.com.car.rent.model.Car;
import br.com.car.rent.model.CarDTO;
import br.com.car.rent.model.Client;
import br.com.car.rent.model.Employee;
import br.com.car.rent.model.HomePage;
import br.com.car.rent.model.Rental;
import br.com.car.rent.model.RentalDTO;
import br.com.car.rent.model.User;

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
	
	public HomePage getHomePageContent() throws SQLException {		
		HomePage home = new HomePage();
		List<RentalDTO> rental;
		
		rental = getClosed();		
		home.setClosedRental(rental.size());
		
		rental = getOpen();
		home.setOpenRental(rental.size());
		
		Date now = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	    
		int late = 0;
		
		for(int i =0; i< rental.size(); i++) {
			Date d = null;
			try {
				d = sdformat.parse(rental.get(i).getRental().getExpectedReturnDate());
				if(d.compareTo(now) > 0) 
					late ++;
			} catch (ParseException e) {				
				e.printStackTrace();
			}			
		}		
		home.setLateRental(late);
		
		List<Client> clients = ClientFacade.getAll();
		home.setActiveClients(clients.size());
		
		List<Employee> employees = EmployeeFacade.getAll();
		home.setActiveEmployees(employees.size());
		
		List<User> users = UserFacade.getAll();
		home.setActiveUsers(users.size());
		
		List<CarDTO> cars = CarFacade.getAll();
		home.setActiveCars(cars.size());
		
		int rented = 0; 
		
		for(int i =0; i< cars.size(); i++) {
			if(cars.get(i).getIsRented() == 0)
				rented ++;
		}
		
		home.setAvailableCars(rented);		
		return home;
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
		CarService carService = new CarService();
		
		return new RentalDTO(clientDAO.getById(item.getClientId(), jdbc),
				employeeDAO.getById(item.getEmployeeId(), jdbc), carService.getById(item.getCarId(), jdbc), item);		
	}
}
