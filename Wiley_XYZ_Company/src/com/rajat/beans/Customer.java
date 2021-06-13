package com.rajat.beans;

public class Customer {
	private long phone_no;
	@Override
	public String toString() {
		return "Customer [phone_no=" + phone_no + ", name=" + name + ", address=" + address + "]";
	}
	public Customer(long phone_no, String name, String address) {
		super();
		this.phone_no = phone_no;
		this.name = name;
		this.address = address;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String name;
	private String address;

}
