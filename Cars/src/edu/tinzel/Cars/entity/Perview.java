package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Perview implements Serializable {
	private int perviewId;
	private String perviewName;
	public int getPerviewId() {
		return perviewId;
	}
	public void setPerviewId(int perviewId) {
		this.perviewId = perviewId;
	}
	public String getPerviewName() {
		return perviewName;
	}
	public void setPerviewName(String perviewName) {
		this.perviewName = perviewName;
	}
	public Perview(int perviewId, String perviewName) {
		super();
		this.perviewId = perviewId;
		this.perviewName = perviewName;
	}
	public Perview() {
		super();
	}
	
	public Perview(String perviewName) {
		super();
		this.perviewName = perviewName;
	}
	@Override
	public String toString() {
		return "Perview [perviewId=" + perviewId + ", perviewName="
				+ perviewName + "]";
	}
	
	
}
