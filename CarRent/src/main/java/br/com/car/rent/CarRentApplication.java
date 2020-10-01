package br.com.car.rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class CarRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentApplication.class, args);
	}
}
