package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Cars implements Serializable {
	private int carId;
	private String carName;
	private String carType;
	private String carColor;
	private int stockId;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public Cars(int carId, String carName, String carType, String carColor,
			int stockId) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.carColor = carColor;
		this.stockId = stockId;
	}
	public Cars(int carId, String carName, String carType, String carColor) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.carColor = carColor;
	}
	public Cars() {
		super();
	}
	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", carName=" + carName + ", carType="
				+ carType + ", carColor=" + carColor + ", stockId=" + stockId
				+ "]";
	}
	
}
