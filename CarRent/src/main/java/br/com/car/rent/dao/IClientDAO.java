package br.com.car.rent.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Client;

public interface IClientDAO {
	public Client getById(Integer id, JdbcTemplate jdbc);
	public void delete(Client c, JdbcTemplate jdbc);
	public void insert(Client c, JdbcTemplate jdbc);	
	public void update(Client c, JdbcTemplate jdbc);
	public Client getByCPF(String cpf, JdbcTemplate jdbc);
	public List<Client> getByName(String name, JdbcTemplate jdbc);
	public List<Client> getAll(JdbcTemplate jdbc);
}
