package br.com.car.rent.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.ClientDAO;
import br.com.car.rent.model.Client;

public class ClientService {
	
	private ClientDAO dao = new ClientDAO();

	public void insert(Client client, JdbcTemplate jdbc) {
		dao.insert(client, jdbc);
	}
	
	public void update(Client client, JdbcTemplate jdbc) {
		dao.update(client, jdbc);
	}
	
	public void delete(Client client, JdbcTemplate jdbc) {
		dao.delete(client, jdbc);
	}
	
	public Client getById(Integer clientId, JdbcTemplate jdbc) {
		return dao.getById(clientId, jdbc);
	}
	
	public Client getByCPF(String cpf, JdbcTemplate jdbc) {
		return dao.getByCPF(cpf, jdbc);
	}
	
	public List<Client> getByName(String name, JdbcTemplate jdbc) {
		if(name == null)
			name = "";
		return dao.getByName(name, jdbc);
	}
}
