package br.com.car.rent.model;

import java.io.Serializable;

public class CarDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;
	String carPlate;
	String model;
	String brand;
	String color;
	String group;
	Integer year;
	Double rentPrice;
	Integer isRented;

	public CarDTO() {}
	
	public CarDTO(Integer id, String carPlate, String model, Integer brand, Integer color, Integer group, Integer year, Double rentPrice, Integer isRented) {
		this.setBrand(brand);
		this.setCarPlate(carPlate);
		this.setColor(color);
		this.setGroup(group);
		this.setId(id);
		this.setModel(model);
		this.setYear(year);
		this.setRentPrice(rentPrice);
		this.setIsRented(isRented);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setBrand(Integer brand) {
		switch (brand) {
		case 1:
			this.brand = "Chevrolet";
			break;
		case 2:
			this.brand = "Citroën";
			break;
		case 3:
			this.brand = "Fiat";
			break;
		case 4:
			this.brand = "Ford";
			break;
		case 5:
			this.brand = "Honda";
			break;
		case 6:
			this.brand = "Hyundai";
			break;
		case 7:
			this.brand = "JAC";
			break;
		case 8:
			this.brand = "Jeep";
			break;
		case 9:
			this.brand = "Kia";
			break;
		case 10:
			this.brand = "Lifan";
			break;
		case 11:
			this.brand = "Mercedes-Benz";
			break;
		case 12:
			this.brand = "Mitsubishi";
			break;
		case 13:
			this.brand = "Nissan";
			break;
		case 14:
			this.brand = "Peugeot";
			break;
		case 15:
			this.brand = "Renault";
			break;
		case 16:
			this.brand = "Suzuki";
			break;
		case 17:
			this.brand = "Toyota";
			break;
		case 18:
			this.brand = "Volkswagen";
			break;
		case 19:
			this.brand = "Volvo";
			break;
		default:
			break;
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setColor(Integer color) {
		switch (color) {
		case 1:
			this.color = "Prata";
			break;
		case 2:
			this.color = "Preto";
			break;
		case 3:
			this.color = "Cinza";
			break;
		case 4:
			this.color = "Branco";
			break;
		case 5:
			this.color = "Vermelho";
			break;
		case 6:
			this.color = "Azul";
			break;
		case 7:
			this.color = "Verde";
			break;
		case 8:
			this.color = "Roxo";
			break;
		default:
			break;
		}
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setGroup(Integer group) {
		switch (group) {
		case 1:
			this.group = "Hatch";
			break;
		case 2:
			this.group = "Sedã";
			break;
		case 3:
			this.group = "Familiar";
			break;
		case 4:
			this.group = "Picape";
			break;
		case 5:
			this.group = "SUV";
			break;
		case 6:
			this.group = "Esportivo";
			break;
		case 7:
			this.group = "Van";
			break;
		case 8:
			this.group = "Furgão";
			break;
		default:
			break;
		}
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Integer getIsRented() {
		return isRented;
	}

	public void setIsRented(Integer isRented) {
		this.isRented = isRented;
	}
}
