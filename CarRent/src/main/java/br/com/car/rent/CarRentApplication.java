package br.com.car.rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.car.rent.dao.DAOFactory;

@SpringBootApplication
public class CarRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentApplication.class, args);
	}

	/**
	 * INITIALIZE DATABASE CONTENT
	 */
	public void run(String... args) throws Exception {
		JdbcTemplate jdbc = DAOFactory.getConnection();
		jdbc.execute("DROP TABLE car IF EXISTS");
		jdbc.execute("CREATE TABLE car(id SERIAL, carPlate VARCHAR(10), model, VARCHAR(50), brand INT, "
				+ "color INT, groupId INT, year INT)");

		jdbc.update("INSERT INTO car(carPlate, model, brand, color, groupId, year) VALUES(?, ?, ?, ?, ?, ?)", "AAA-1111", "VW-Fox 1.6",
				1, 2, 3, 2020);

	}
}
