package br.com.car.rent.model;


public class ResponseModel {
	private Integer status;
	private String description;
	
	public ResponseModel() {}
	
	public ResponseModel(Integer status, String description) {
		this.status = status;
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
