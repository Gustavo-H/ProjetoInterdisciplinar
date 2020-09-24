package br.com.car.rent.model;

import java.io.Serializable;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value="/car-rent/employees")

public class Employee extends DeleteManagement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	String name;
	String serial;
	String cpf;
	Integer role;

	public Employee() {}
	
	public Employee(Integer id, String name, String serial, String cpf, Integer role) {
		this.setCpf(cpf);
		this.setId(id);
		this.setName(name);
		this.setRole(role);
		this.setSerial(serial);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
