package br.com.car.rent.model;

import java.io.Serializable;

public class Rental implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	Integer clientId;
	Integer employeeId;
	Integer carId;
	Double discount;
	Double dailyCost;
	String dateWithdrawal;
	String expectedReturnDate;
	String effectiveReturnDate;

	public Rental() {}

	public Rental(Integer id, Integer clientId, Integer employeeId, Integer carId, Double discount, Double dailyCost,
			String dateWithdrawal, String expectedReturnDate, String effectiveReturnDate) {
		this.setCarId(carId);
		this.setClientId(clientId);
		this.setDateWithdrawal(dateWithdrawal);
		this.setEffectiveReturnDate(effectiveReturnDate);
		this.setEmployeeId(employeeId);
		this.setExpectedReturnDate(expectedReturnDate);
		this.setId(id);
		this.setDiscount(discount);
		this.setDailyCost(dailyCost);
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

	public String getDateWithdrawal() {
		return dateWithdrawal;
	}

	public void setDateWithdrawal(String dateWithdrawal) {
		this.dateWithdrawal = dateWithdrawal;
	}

	public String getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(String expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public String getEffectiveReturnDate() {
		return effectiveReturnDate;
	}

	public void setEffectiveReturnDate(String effectiveReturnDate) {
		this.effectiveReturnDate = effectiveReturnDate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(Double dailyCost) {
		this.dailyCost = dailyCost;
	}

}
