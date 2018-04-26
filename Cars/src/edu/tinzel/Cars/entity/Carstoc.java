package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Carstoc implements Serializable {
	private int carId; //汽车编号
	private String carName;//汽车名称
	private String carType;//汽车型号
	private String engineId;//发动机型号
	private String carToArea;//车辆流向
	private String createDate;//汽车生产日期
	private String carColor;//汽车颜色
	private String carFromArea;//汽车生产地
	private int stockId;//仓库编号
	private String stockName;//仓库名称
	private String intoStockDate;//入库日期
	private String remarks;//汽车描述
	private int maxSum;//仓库最大库存
	private int liveSum;//仓库当前库存
	private String stockPlace;//仓库地址
	
	public String getStockPlace() {
		return stockPlace;
	}
	public void setStockPlace(String stockPlace) {
		this.stockPlace = stockPlace;
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
	public String getEngineId() {
		return engineId;
	}
	public void setEngineId(String engineId) {
		this.engineId = engineId;
	}
	public String getCarToArea() {
		return carToArea;
	}
	public void setCarToArea(String carToArea) {
		this.carToArea = carToArea;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarFromArea() {
		return carFromArea;
	}
	public void setCarFromArea(String carFromArea) {
		this.carFromArea = carFromArea;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getIntoStockDate() {
		return intoStockDate;
	}
	public void setIntoStockDate(String intoStockDate) {
		this.intoStockDate = intoStockDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getMaxSum() {
		return maxSum;
	}
	public void setMaxSum(int maxSum) {
		this.maxSum = maxSum;
	}
	public int getLiveSum() {
		return liveSum;
	}
	public void setLiveSum(int liveSum) {
		this.liveSum = liveSum;
	}
	public Carstoc(int carId, String carName, String carType, String engineId,
			String carToArea, String createDate, String carColor,
			String carFromArea, int stockId, String stockName,
			String intoStockDate, String remarks) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.engineId = engineId;
		this.carToArea = carToArea;
		this.createDate = createDate;
		this.carColor = carColor;
		this.carFromArea = carFromArea;
		this.stockId = stockId;
		this.stockName = stockName;
		this.intoStockDate = intoStockDate;
		this.remarks = remarks;
	}
	public Carstoc() {
		super();
	}
	
	public Carstoc(int carId, String carName, String carType, String engineId,
			String carToArea, String createDate, String carColor,
			String carFromArea, int stockId, String stockName,
			String intoStockDate, String remarks, int maxSum, int liveSum) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.engineId = engineId;
		this.carToArea = carToArea;
		this.createDate = createDate;
		this.carColor = carColor;
		this.carFromArea = carFromArea;
		this.stockId = stockId;
		this.stockName = stockName;
		this.intoStockDate = intoStockDate;
		this.remarks = remarks;
		this.maxSum = maxSum;
		this.liveSum = liveSum;
	}
	
	public Carstoc(int stockId, String stockName, int maxSum, String stockPlace) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.maxSum = maxSum;
		this.stockPlace = stockPlace;
	}
	
	public Carstoc(String carName, String carType, int stockId, int maxSum,
			int liveSum) {
		super();
		this.carName = carName;
		this.carType = carType;
		this.stockId = stockId;
		this.maxSum = maxSum;
		this.liveSum = liveSum;
	}
	@Override
	public String toString() {
		return "Carstoc [carId=" + carId + ", carName=" + carName
				+ ", carType=" + carType + ", engineId=" + engineId
				+ ", carToArea=" + carToArea + ", createDate=" + createDate
				+ ", carColor=" + carColor + ", carFromArea=" + carFromArea
				+ ", stockId=" + stockId + ", stockName=" + stockName
				+ ", intoStockDate=" + intoStockDate + ", remarks=" + remarks
				+ ", maxSum=" + maxSum + ", liveSum=" + liveSum
				+ ", stockPlace=" + stockPlace + "]";
	}
	public Carstoc(String carName, String carType, String stockName,
			int maxSum, int liveSum, String stockPlace) {
		super();
		this.carName = carName;
		this.carType = carType;
		this.stockName = stockName;
		this.maxSum = maxSum;
		this.liveSum = liveSum;
		this.stockPlace = stockPlace;
	}
	
	
}
