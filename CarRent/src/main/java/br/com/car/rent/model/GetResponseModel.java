package br.com.car.rent.model;

public class GetResponseModel<T> extends ResponseModel {
	
	private T responseObject;
	
	public GetResponseModel() {}
	
	public GetResponseModel(Integer status, String description, T responseObject) {
		super(status, description);
		this.responseObject = responseObject;
	}

	public T getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}	
}
