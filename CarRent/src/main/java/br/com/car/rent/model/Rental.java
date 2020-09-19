package br.com.car.rent.model;

import java.util.Calendar;

public class Rental {
	Integer id;
	Integer clientId;
	Integer employeeId;
	Integer carId;
	Calendar dateWithdrawal;
	Calendar expectedReturnDate;
	Calendar effectiveReturnDate;
	
	public Rental() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Calendar getDateWithdrawal() {
		return dateWithdrawal;
	}

	public void setDateWithdrawal(Calendar dateWithdrawal) {
		this.dateWithdrawal = dateWithdrawal;
	}

	public Calendar getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Calendar expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Calendar getEffectiveReturnDate() {
		return effectiveReturnDate;
	}

	public void setEffectiveReturnDate(Calendar effectiveReturnDate) {
		this.effectiveReturnDate = effectiveReturnDate;
	}
	
	

}
