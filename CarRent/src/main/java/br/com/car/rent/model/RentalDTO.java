package br.com.car.rent.model;

import java.io.Serializable;

public class RentalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	Client client;
	Employee employee;
	CarDTO car;
	Rental rental;

	public RentalDTO() {
	}

	public RentalDTO(Client client, Employee employee, CarDTO car, Rental rental) {

		this.setCar(car);
		this.setClient(client);
		this.setEmployee(employee);
		this.setRental(rental);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public CarDTO getCar() {
		return car;
	}

	public void setCar(CarDTO car) {
		this.car = car;
	}
	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
}