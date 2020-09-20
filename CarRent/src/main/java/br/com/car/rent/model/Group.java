package br.com.car.rent.model;

import java.io.Serializable;

public class Group extends DeleteManagement implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	String name;
	String description;

	public Group() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
