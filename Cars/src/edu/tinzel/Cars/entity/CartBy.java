package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class CartBy implements Serializable {
	private String stockName;
	private String CarName;
	private String CarType;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String carName) {
		CarName = carName;
	}
	public String getCarType() {
		return CarType;
	}
	public void setCarType(String carType) {
		CarType = carType;
	}
	public CartBy(String stockName, String carName, String carType) {
		super();
		this.stockName = stockName;
		CarName = carName;
		CarType = carType;
	}
	public CartBy() {
		super();
	}
	
}
