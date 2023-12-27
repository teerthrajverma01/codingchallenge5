package com.entity.model;

public class Customer {
	
	//attribute
	private int customerId;	
	private String name;	
	private String emailAddress;	
	private String phoneNumber;
	private String address;
	private int creditScore;
	
	//constructor
	public Customer(int customerId, String name, String emailAddress, String phoneNumber, String address,
			int creditScore) {
		
		this.customerId = customerId;
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creditScore = creditScore;
	}

	//getter and setter
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", creditScore=" + creditScore + "]";
	}
	
	
	
}
