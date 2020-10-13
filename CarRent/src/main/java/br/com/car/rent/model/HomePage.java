package br.com.car.rent.model;

import java.io.Serializable;

public class HomePage implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer openRental;
	Integer closedRental; 
	Integer lateRental;
	
	Integer activeClients; 
	Integer activeEmployees;	
	Integer activeUsers;
	
	Integer activeCars;
	Integer availableCars;
	
	public HomePage() {}

	public Integer getOpenRental() {
		return openRental;
	}

	public void setOpenRental(Integer openRental) {
		this.openRental = openRental;
	}

	public Integer getClosedRental() {
		return closedRental;
	}

	public void setClosedRental(Integer closedRental) {
		this.closedRental = closedRental;
	}

	public Integer getLateRental() {
		return lateRental;
	}

	public void setLateRental(Integer lateRental) {
		this.lateRental = lateRental;
	}

	public Integer getActiveClients() {
		return activeClients;
	}

	public void setActiveClients(Integer activeClients) {
		this.activeClients = activeClients;
	}

	public Integer getActiveEmployees() {
		return activeEmployees;
	}

	public void setActiveEmployees(Integer activeEmployees) {
		this.activeEmployees = activeEmployees;
	}

	public Integer getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(Integer activeUsers) {
		this.activeUsers = activeUsers;
	}

	public Integer getActiveCars() {
		return activeCars;
	}

	public void setActiveCars(Integer activeCars) {
		this.activeCars = activeCars;
	}

	public Integer getAvailableCars() {
		return availableCars;
	}

	public void setAvailableCars(Integer availableCars) {
		this.availableCars = availableCars;
	}
}
