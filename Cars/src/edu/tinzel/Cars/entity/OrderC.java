package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class OrderC implements Serializable {
	private int orderId;
	private int customerId;
	private int carId;
	private String carName;
	private String carType;
	private double sellPrice;
	private String carToArea;
	private String sellDate;
	private int state;
	private String states;
	private String remark;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStates() {	 
		if(getState()==0){
			return "未发货";
		}else if(getState()==1){
			return "在路上";
		}else if(getState()==2){
			return "已到达";
		}
		return "未出售";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
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
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getCarToArea() {
		return carToArea;
	}
	public void setCarToArea(String carToArea) {
		this.carToArea = carToArea;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public OrderC(int orderId, int customerId, int carId, String carName,
			String carType, double sellPrice, String carToArea,
			String sellDate, int state) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.sellPrice = sellPrice;
		this.carToArea = carToArea;
		this.sellDate = sellDate;
		this.state = state;
	}
	public OrderC() {
		super();
	}
	@Override
	public String toString() {
		return "OrderC [orderId=" + orderId + ", customerId=" + customerId
				+ ", carId=" + carId + ", carName=" + carName + ", carType="
				+ carType + ", sellPrice=" + sellPrice + ", carToArea="
				+ carToArea + ", sellDate=" + sellDate + ", state=" + state
				+ ", states=" + states + "]";
	}
	public OrderC(int orderId, int customerId, int carId, String carName,
			String carType, double sellPrice, String carToArea,
			String sellDate, int state, String states) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.sellPrice = sellPrice;
		this.carToArea = carToArea;
		this.sellDate = sellDate;
		this.state = state;
		this.states = states;
	}
	public OrderC(int customerId, int carId, String carName, String carType,
			double sellPrice, String carToArea, String sellDate, int state, String remark) {
		super();
		this.customerId = customerId;
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.sellPrice = sellPrice;
		this.carToArea = carToArea;
		this.sellDate = sellDate;
		this.state = state;
		this.remark = remark;
	}
	
	
	
}
