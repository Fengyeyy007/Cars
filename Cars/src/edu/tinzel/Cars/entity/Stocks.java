package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Stocks implements Serializable {
	private int stockId;
	private String stockName;
	private String stockPlace;
	private int maxSum;
	private int liveSum;
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
	public String getStockPlace() {
		return stockPlace;
	}
	public void setStockPlace(String stockPlace) {
		this.stockPlace = stockPlace;
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
	public Stocks(int stockId, String stockName, String stockPlace, int maxSum,
			int liveSum) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPlace = stockPlace;
		this.maxSum = maxSum;
		this.liveSum = liveSum;
	}
	public Stocks() {
		super();
	}
	
	public Stocks(int stockId, String stockName) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
	}
	
	public Stocks(String stockName, String stockPlace, int maxSum) {
		super();
		this.stockName = stockName;
		this.stockPlace = stockPlace;
		this.maxSum = maxSum;
	}
	@Override
	public String toString() {
		return "Stocks [stockId=" + stockId + ", stockName=" + stockName
				+ ", stockPlace=" + stockPlace + ", maxSum=" + maxSum
				+ ", liveSum=" + liveSum + "]";
	}
	
}
