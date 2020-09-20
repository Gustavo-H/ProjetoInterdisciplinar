package br.com.car.rent.model;

import java.io.Serializable;

public class Car extends DeleteManagement implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	String carPlate;
	String model;
	Integer brand;	
	Integer color;
	Integer groupId;
	Integer year;
	
	public Car() {}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer id) {
		this.groupId = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
}
