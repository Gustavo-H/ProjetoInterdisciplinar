package br.com.car.rent.model;

import java.io.Serializable;

public class Car extends DeleteManagement implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	String carPlate;
	String model;
	Integer brand;	
	Integer color;
	Integer group;
	Integer year;
	Double rentPrice;
	
	public Car() {}
	
	public Car(Integer id) {
		this.setId(id);
	}
	
	public Car(Integer id, String carPlate, String model, Integer brand, Integer color, Integer group, Integer year, Double rentPrice) {
		this.setBrand(brand);
		this.setCarPlate(carPlate);
		this.setColor(color);
		this.setGroup(group);
		this.setId(id);
		this.setModel(model);
		this.setYear(year);
		this.setRentPrice(rentPrice);
	}
	
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

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer id) {
		this.group = id;
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

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}
}
