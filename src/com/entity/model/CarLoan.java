package com.entity.model;

public class CarLoan extends Loan {
	
	//attribute
	private String carModel;
	private int carValue;
	
	//getter and setter
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarValue() {
		return carValue;
	}
	public void setCarValue(int carValue) {
		this.carValue = carValue;
	}

	//constructor
	public CarLoan(int loanId, int customerId, double principalAmount, double interestRate, int loanTerm,
			String loanType, String loanStatus, String carModel, int carValue) {
		super(loanId, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus);
		this.carModel = carModel;
		this.carValue = carValue;
	}

	@Override
	public String toString() {
		return "CarLoan [carModel=" + carModel + ", carValue=" + carValue + ", toString()=" + super.toString() + "]";
	}
	
	

}
