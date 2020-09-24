package br.com.car.rent.model;

import java.util.Calendar;

public abstract class DeleteManagement {
	Boolean isDeleted;
	Calendar deletedDate; 
	Integer deletedBy;
	
	public DeleteManagement() {}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public void setIsDeleted(String isDeleted) {
		if(isDeleted.toLowerCase() == "true")
			this.isDeleted = true;
		else
			this.isDeleted = false;
	}
	
	public void setIsDeleted(int isDeleted) {
		if(isDeleted == 1)
			this.isDeleted = true;
		else
			this.isDeleted = false;
	}

	public Calendar getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Calendar deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}	
}
