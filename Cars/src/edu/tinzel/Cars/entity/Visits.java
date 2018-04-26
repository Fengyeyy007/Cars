package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Visits implements Serializable {
	private int id;
	private String customerName;
	private String visitDate;
	private String visitEvent;
	private String visitReCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitEvent() {
		return visitEvent;
	}
	public void setVisitEvent(String visitEvent) {
		this.visitEvent = visitEvent;
	}
	public String getVisitReCode() {
		return visitReCode;
	}
	public void setVisitReCode(String visitReCode) {
		this.visitReCode = visitReCode;
	}
	public Visits(int id, String customerName, String visitDate,
			String visitEvent, String visitReCode) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.visitDate = visitDate;
		this.visitEvent = visitEvent;
		this.visitReCode = visitReCode;
	}
	public Visits() {
		super();
	}
	@Override
	public String toString() {
		return "Visits [id=" + id + ", customerName=" + customerName
				+ ", visitDate=" + visitDate + ", visitEvent=" + visitEvent
				+ ", visitReCode=" + visitReCode + "]";
	}
	
}
