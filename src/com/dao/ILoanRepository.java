package com.dao;

import com.entity.model.Loan;
import com.exception.InvalidLoanException;

public interface ILoanRepository {

	/* 	applyLoan(loan Loan): 
	* pass appropriate parameters for creating loan. Initially loan
	* status is pending and stored in database. before storing in database get confirmation from the user as Yes/No
	*/
	void applyLoan(Loan obj) throws Exception ;
	
	
	/*  calculateInterest(loanId): 
	 * This method should calculate and return the interest amount for the loan. 
	 * Loan should be retrieved from database and calculate the interest amount if loan not found generate InvalidLoanException.
	 *  i. Overload the same method with required parameters to calculate the loan interest amount. It is used to calculate the loan interest while creating loan.
	 *  ii. Interest = (Principal Amount * Interest Rate * Loan Tenure) / 12
	*/ 
	void calculateInterest(int loanId) throws Exception;
	
	/*  loanStatus(loanId): 
	 * This method should display a message indicating that the loan is approved or rejected based on credit score,
	 *  if credit score above 650 loan approved else rejected and should update in database.
	*/
	void loanStatus(int loanId) throws Exception;
	
	
	/* calculateEMI(loanId): This method will calculate the emi amount for a month to repayment. 
	 * Loan should be retrieved from database and calculate the interest amount, if loan not found generate InvalidLoanException.
	 * i. Overload the same method with required parameters to calculate the loan EMI amount. It is used to calculate the loan EMI while creating loan.
	 * ii. EMI = [P * R * (1+R)^N] / [(1+R)^N-1]
		1. EMI: The Equated Monthly Installment.
		2. P: Principal Amount (Loan Amount).
		3. R: Monthly Interest Rate (Annual Interest Rate / 12 / 100).
		4. N: Loan Tenure in months.
	*/
	double calculateEMI(int loanId) throws Exception;
	
	/* loanRepayment(loanId, amount): 
	 * calculate the noOfEmi can be paid from the amount if the amount is less than single emi reject the payment or 
	 * pay the emi in whole number and update the variable.
	*/
	void loanRepayment(int loanId,int amount) throws Exception;

	
	/*  getAllLoan():
	 * get all loan as list and print the details.
	*/
	void  getAllLoan() throws Exception ;
	
	Loan loanDetail(int loanId) throws Exception;
	
	
	/*  getLoanById(loanId):
	*  get loan and print the details, if loan not found generate InvalidLoanException.
	*/
	void  getLoanById(int loanId) throws Exception;
	
}
