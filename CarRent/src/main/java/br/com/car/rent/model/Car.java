package br.com.car.rent.model;

import java.io.Serializable;

public class Car  implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	String carPlate;
	String model;
	Integer brand;	
	Integer color;
	Integer goup;
	Integer year;
	
	public Car(	Integer id,	String carPlate, String model, Integer brand, Integer color, Integer goup, Integer year) {
		this.setBrand(brand);
		this.setCarPlate(carPlate);
		this.setColor(color);
		this.setGoup(goup);
		this.setId(id);
		this.setModel(model);
		this.setYear(year);
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

	public Integer getGoup() {
		return goup;
	}

	public void setGoup(Integer goup) {
		this.goup = goup;
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
