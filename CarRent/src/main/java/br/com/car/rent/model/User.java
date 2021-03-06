package br.com.car.rent.model;

import java.io.Serializable;

public class User extends DeleteManagement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	String name;
	String login;
	String password;
	Integer ownerId;
	Integer type;

	public User() {}
	
	public User(Integer id, String name, String login, String password, Integer ownerId, Integer type) {
		this.setId(id);
		this.setName(name);
		this.setLogin(login);
		this.setOwnerId(ownerId);
		this.setPassword(password);
		this.setType(type);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
