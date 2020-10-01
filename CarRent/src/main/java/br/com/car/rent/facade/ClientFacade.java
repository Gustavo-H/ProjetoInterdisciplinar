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
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void update(Client client) throws SQLException {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		try {
			clientService.update(client, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void delete(Client client) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			clientService.delete(client, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static Client getById(Integer clientId) throws SQLException {
		Client ret = null;
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			ret = clientService.getById(clientId, jdbc);
			return ret;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static Client getByCPF(String cpf) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return clientService.getByCPF(cpf, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static List<Client> getByName(String name) throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return clientService.getByName(name, jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static List<Client> getAll() throws SQLException {
		try {
			JdbcTemplate jdbc = DAOFactory.getConnection();
			return clientService.getAll(jdbc);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}
