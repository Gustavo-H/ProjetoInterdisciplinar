package br.com.car.rent.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.model.Client;

public class ClientDAO implements IClientDAO {

	@Override
	public Client getById(Integer id, JdbcTemplate jdbc) {
		ClientRowMapper mapper = new ClientRowMapper();
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM CLIENT WHERE CLIENT.id = ?",id));
	}

	@Override
	public void delete(Client c, JdbcTemplate jdbc) {
		jdbc.update("UPDATE CLIENT SET is_deleted=1, deleted_date=CURRENT_TIMESTAMP, deleted_by=? WHERE CLIENT.id=?",
				c.getDeletedBy(),
				c.getId());		
	}

	@Override
	public void insert(Client c, JdbcTemplate jdbc) {
		jdbc.update("INSERT INTO CLIENT(name, cpf, rg, birthday, address, contact, email) VALUES(?, ?, ?, ?, ?, ?, ?)", 
				c.getName(),
				c.getCpf(),
				c.getRg(),
				c.getBirthday(),
				c.getAddress().getId(),
				c.getContact(), 
				c.getEmail());		
	}

	@Override
	public void update(Client c, JdbcTemplate jdbc) {
		jdbc.update("UPDATE CLIENT SET name=?, cpf=?, rg=?, birthday=?, address=?, contact=?, email=? WHERE CLIENT.id=?", 
				c.getName(),
				c.getCpf(),
				c.getRg(),
				c.getBirthday(),
				c.getAddress().getId(),
				c.getContact(), 
				c.getEmail(),
				c.getId());		
	}

	@Override
	public Client getByCPF(String cpf, JdbcTemplate jdbc) {
		ClientRowMapper mapper = new ClientRowMapper();
		return mapper.mapRow(jdbc.queryForRowSet("SELECT * FROM CLIENT WHERE CLIENT.cpf = ?",cpf));
	}

	@Override
	public List<Client> getByName(String name, JdbcTemplate jdbc) {
		return jdbc.query("SELECT * FROM CLIENT WHERE CLIENT.name LIKE '%" + name + "%';", new ClientRowMapper());
	}

}
