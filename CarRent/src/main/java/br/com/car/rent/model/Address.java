package br.com.car.rent.model;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	String cep;
	String street;
	Integer number;
	String neighborhood;
	String city;
	String state;
	String complement;

	public Address() {
	}

	public Address(Integer id, String cep, String street, Integer number, String neighborhood, String city, String state,
			String complement) {
		this.setCity(city);
		this.setComplement(complement);
		this.setId(id);
		this.setNeighborhood(neighborhood);
		this.setNumber(number);
		this.setState(state);
		this.setStreet(street);
		this.setCep(cep);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
