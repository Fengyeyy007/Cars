package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Customers implements Serializable {
	private int customerId;
	private String customerName;
	private String customerGender;
	private String customerPhone;
	private String customerCode;
	private String customerAdd;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerAdd() {
		return customerAdd;
	}
	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}
	public Customers(int customerId, String customerName,
			String customerGender, String customerPhone, String customerCode,
			String customerAdd) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerCode = customerCode;
		this.customerAdd = customerAdd;
	}
	public Customers() {
		super();
	}
	
	public Customers(String customerName, String customerGender,
			String customerPhone, String customerCode, String customerAdd) {
		super();
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerCode = customerCode;
		this.customerAdd = customerAdd;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName="
				+ customerName + ", customerGender=" + customerGender
				+ ", customerPhone=" + customerPhone + ", customerCode="
				+ customerCode + ", customerAdd=" + customerAdd + "]";
	}
	
}
