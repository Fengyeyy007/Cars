package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class CustTj implements Serializable {
	public String customerAdd;
	public int count;
	public String getCustomerAdd() {
		return customerAdd;
	}
	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CustTj(String customerAdd, int count) {
		super();
		this.customerAdd = customerAdd;
		this.count = count;
	}
	@Override
	public String toString() {
		return "CustTj [customerAdd=" + customerAdd + ", count=" + count + "]";
	}
	
}
