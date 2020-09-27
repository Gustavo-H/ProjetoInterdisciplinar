package br.com.car.rent.model;

import java.io.Serializable;
import java.util.Calendar;

public class Rental implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	Integer clientId;
	Integer employeeId;
	Integer carId;
	Double discount;
	Calendar dateWithdrawal;
	Calendar expectedReturnDate;
	Calendar effectiveReturnDate;

	public Rental() {}

	public Rental(Integer id, Integer clientId, Integer employeeId, Integer carId, Double discount, Calendar dateWithdrawal,
			Calendar expectedReturnDate, Calendar effectiveReturnDate) {
		this.setCarId(carId);
		this.setClientId(clientId);
		this.setDateWithdrawal(dateWithdrawal);
		this.setEffectiveReturnDate(effectiveReturnDate);
		this.setEmployeeId(employeeId);
		this.setExpectedReturnDate(expectedReturnDate);
		this.setId(carId);
		this.setDiscount(discount);
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

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
