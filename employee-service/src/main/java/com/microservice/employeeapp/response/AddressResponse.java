package com.microservice.employeeapp.response;

public class AddressResponse {
private int id;
private String line1;
private String line2;
private long zip;
private String state;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLine1() {
	return line1;
}
public void setLine1(String line1) {
	this.line1 = line1;
}
public String getLine2() {
	return line2;
}
public void setLine2(String line2) {
	this.line2 = line2;
}
public long getZip() {
	return zip;
}
public void setZip(long zip) {
	this.zip = zip;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

}
