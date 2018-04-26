package edu.tinzel.Cars.entity;

import java.io.Serializable;

public class Firms implements Serializable {
	private int firmId;
	private String firmName;
	private String firmPerson;
	private String firmPhone;
	private String firmZip;
	private String firmAdds;
	public int getFirmId() {
		return firmId;
	}
	public void setFirmId(int firmId) {
		this.firmId = firmId;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getFirmPerson() {
		return firmPerson;
	}
	public void setFirmPerson(String firmPerson) {
		this.firmPerson = firmPerson;
	}
	public String getFirmPhone() {
		return firmPhone;
	}
	public void setFirmPhone(String firmPhone) {
		this.firmPhone = firmPhone;
	}
	public String getFirmZip() {
		return firmZip;
	}
	public void setFirmZip(String firmZip) {
		this.firmZip = firmZip;
	}
	public String getFirmAdds() {
		return firmAdds;
	}
	public void setFirmAdds(String firmAdds) {
		this.firmAdds = firmAdds;
	}
	public Firms(int firmId, String firmName, String firmPerson,
			String firmPhone, String firmZip, String firmAdds) {
		super();
		this.firmId = firmId;
		this.firmName = firmName;
		this.firmPerson = firmPerson;
		this.firmPhone = firmPhone;
		this.firmZip = firmZip;
		this.firmAdds = firmAdds;
	}
	public Firms() {
		super();
	}
	
	public Firms(String firmName, String firmPerson, String firmPhone,
			String firmZip, String firmAdds) {
		super();
		this.firmName = firmName;
		this.firmPerson = firmPerson;
		this.firmPhone = firmPhone;
		this.firmZip = firmZip;
		this.firmAdds = firmAdds;
	}
	@Override
	public String toString() {
		return "Firms [firmId=" + firmId + ", firmName=" + firmName
				+ ", firmPerson=" + firmPerson + ", firmPhone=" + firmPhone
				+ ", firmZip=" + firmZip + ", firmAdds=" + firmAdds + "]";
	}
	
}
