package br.com.car.rent.facade;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.DAOFactory;
import br.com.car.rent.model.Client;
import br.com.car.rent.service.ClientService;

public class ClientFacade {
	
	private static ClientService clientService = new ClientService();
	
	public static void insert(Client client) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			clientService.insert(client, jdbc);			
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Client client) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			clientService.update(client, jdbc);		
		}
		catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Client client) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		clientService.delete(client, jdbc);
	}
		
	public static Client getById(Integer clientId) throws SQLException {
		Client ret = null;
		JdbcTemplate jdbc = DAOFactory.getConnection();
		ret = clientService.getById(clientId, jdbc);
		return ret;
	}
	
	public static Client getByCPF(String cpf) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return clientService.getByCPF(cpf, jdbc);
	}
	
	public static  List<Client> getByName(String name) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		return clientService.getByName(name, jdbc);
	}
}
