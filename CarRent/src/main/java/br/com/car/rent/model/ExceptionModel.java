package br.com.car.rent.model;

public class ExceptionModel {

	private Integer status;
	private String reason;
	private String description;
	
	public ExceptionModel() {}
	
	public ExceptionModel(Integer status, String reason, String description) {
		this.status = status;
		this.reason = reason;
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
