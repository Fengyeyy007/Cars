package edu.tinzel.Cars.entity;

import java.io.Serializable;
import java.util.List;

public class Ccarstocks implements Serializable {
	public int stockId;
	public String stockName;
	public String stockPlace;
	public int maxSum;
	public List<Carstoc> carstoclist;
	
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

	public List<Carstoc> getCarstoclist() {
		return carstoclist;
	}

	public void setCarstoclist(List<Carstoc> carstoclist) {
		this.carstoclist = carstoclist;
	}

	public Ccarstocks() {
		super();
	}
	
	public Ccarstocks(int stockId, String stockName, String stockPlace,
			int maxSum) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPlace = stockPlace;
		this.maxSum = maxSum;
	}

	public Ccarstocks(int stockId, String stockName, String stockPlace,
			int maxSum, List<Carstoc> carstoclist) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPlace = stockPlace;
		this.maxSum = maxSum;
		this.carstoclist = carstoclist;
	}

	@Override
	public String toString() {
		return "Ccarstocks [stockId=" + stockId + ", stockName=" + stockName
				+ ", stockPlace=" + stockPlace + ", maxSum=" + maxSum
				+ ", carstoclist=" + carstoclist + "]";
	}
	
	
}
