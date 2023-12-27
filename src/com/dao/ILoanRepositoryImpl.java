package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.model.CarLoan;
import com.entity.model.HomeLoan;
import com.entity.model.Loan;
import com.exception.InvalidLoanException;

/* Define ILoanRepositoryImpl class and implement the ILoanRepository interface and provide implementation of all methods.*/


public class ILoanRepositoryImpl implements ILoanRepository {
	
	public void applyLoan(Loan obj )throws SQLException,InvalidLoanException{
		try {
			String q1 = "INSERT INTO loan(loanId, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus) values (?,?,?,?,?,?,?)";
			PreparedStatement pstmt1 = DAO.con.prepareStatement(q1);
			pstmt1.setInt(1, obj.getLoanId());
			pstmt1.setInt(2, obj.getCustomerId());
			pstmt1.setDouble(3, obj.getPrincipalAmount());
			pstmt1.setDouble(4, obj.getInterestRate());
			pstmt1.setInt(5, obj.getLoanTerm());
			pstmt1.setString(6, obj.getLoanType());
			pstmt1.setString(7, obj.getLoanStatus());
			pstmt1.executeUpdate();
			
			if(obj.getLoanType() == "CarLoan") {
				String q2 = "INSERT INTO carloan(loanId,carModel,carValue) values(?,?,?)";			
				PreparedStatement pstmt2 = DAO.con.prepareStatement(q2);
				pstmt2.setInt(1, obj.getLoanId());
				pstmt2.setString(2, ((CarLoan) obj).getCarModel());
				pstmt2.setInt(3, ((CarLoan) obj).getCarValue());
				pstmt2.executeUpdate();
			}
			else if(obj.getLoanType() == "HomeLoan"){
				String q2 = "INSERT INTO  homeloan(loanId,propertyAddress,propertyValue) values(?,?,?)";	
				PreparedStatement pstmt2 = DAO.con.prepareStatement(q2);
				pstmt2.setInt(1, obj.getLoanId());
				pstmt2.setString(2, ((HomeLoan) obj).getPropertyAddress());
				pstmt2.setInt(3, ((HomeLoan) obj).getPropertyValue());
				pstmt2.executeUpdate();
			}
			else {
		         throw new InvalidLoanException("Unsupported loan type: " + obj.getLoanType());
		    }
		}catch (SQLException e) {
			System.out.println(e);
		}			
	}	

	
	public void loanStatus(int loanId) throws SQLException,InvalidLoanException{
		try {
				String q1 = "SELECT creditScore FROM Customer c JOIN Loan l ON c.customerID = l.customerID WHERE l.loanID = ?";
				PreparedStatement pstmt1 = DAO.con.prepareStatement(q1);
				pstmt1.setInt(1,loanId);
				ResultSet lstatus  = pstmt1.executeQuery();
				int creditScore;
				String ls="Pending";
				if (lstatus.next()) {
	                 creditScore= lstatus.getInt("creditScore");
	                 if (creditScore > 650) {
	                	 ls="Approved";
	                	 System.out.println("Loan with ID " + loanId + " is approved.");
	                 }
	                 else { 
	                	 ls = "Rejected";
	                	 System.out.println("Loan with ID " + loanId + " is rejected.");
	                	 throw new InvalidLoanException("Failed to update loan status.");
	                 }
				}
				
				String updateLoanStatusQuery = "UPDATE Loan SET loanStatus = ? WHERE loanId = ?";
	            PreparedStatement pstmt2= DAO.con.prepareStatement(updateLoanStatusQuery);
	            pstmt2.setString(1, ls);
	            pstmt2.setInt(2, loanId);
	            int rowsAffected =pstmt2.executeUpdate();
	            if (rowsAffected > 0) {
	            	System.out.println("Loan Status Updated: " + ls);
	            }
	            else {
	                  throw new InvalidLoanException("Failed to update loan status.");
	            }
		}catch (SQLException e) {
			System.out.println(e);
		}
	};
	
	public  void getAllLoan() throws SQLException  {
		
		List<Loan> loanList = new ArrayList<>();
		try {
			Statement stmt1 =  DAO.con.createStatement();
			String q1 = "SELECT * FROM loan";	
			ResultSet getAllLoanset = stmt1.executeQuery(q1);
			
			while(getAllLoanset.next()) { // check if row is there in set not
				  	Loan loan = new Loan();
					loan.setLoanId( getAllLoanset.getInt("loanId"));
					loan.setCustomerId(getAllLoanset.getInt("customerId"));
					loan.setPrincipalAmount(getAllLoanset.getDouble("principalAmount"));
					loan.setInterestRate(getAllLoanset.getDouble("interestRate"));
					loan.setLoanTerm(getAllLoanset.getInt("loanTerm"));
					loan.setLoanType(getAllLoanset.getString("loanType"));
					loan.setLoanStatus(getAllLoanset.getString("loanStatus"));	
					loanList.add(loan);	
				}
			for (Loan loanitem : loanList) {
	            System.out.println(loanitem.toString());
	        	}	
		}catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	public void  getLoanById(int loanId) throws Exception{
		String q1 = "SELECT * FROM loan WHERE loanId=?";
		PreparedStatement pstmt1 =  DAO.con.prepareStatement(q1);	
		pstmt1.setInt(1, loanId);	
		ResultSet loanbyid = pstmt1.executeQuery();
		if (loanbyid.next()) {
            Loan loan = new Loan();        
            loan.setLoanId( loanbyid.getInt("loanId"));
			loan.setCustomerId(loanbyid.getInt("customerId"));
			loan.setPrincipalAmount(loanbyid.getDouble("principalAmount"));
			loan.setInterestRate(loanbyid.getDouble("interestRate"));
			loan.setLoanTerm(loanbyid.getInt("loanTerm"));
			loan.setLoanType(loanbyid.getString("loanType"));
			loan.setLoanStatus(loanbyid.getString("loanStatus"));	
			System.out.println(loan.toString());
		}
	}

	
	
	public void calculateInterest(int loanId) throws Exception{	
		Loan loanDetail = loanDetail(loanId);
	    Double principalAmount=loanDetail.getPrincipalAmount();
	    Double interestRate=loanDetail.getInterestRate();
	    int loanTenure=loanDetail.getLoanTerm();
        System.out.println("principalAmount: "+ principalAmount+"   interestRate: "+interestRate+"     loanTenure: "+loanTenure);
	    Double interest=(principalAmount * interestRate * loanTenure)/12;
	    System.out.println("calculatedInterest: " +interest);
	}

	
	public double calculateEMI(int loanId) throws Exception{
		Loan loanDetail = loanDetail(loanId);
		Double Emi=0.0;
		if(loanDetail!=null) {
			Double R=((loanDetail.getInterestRate())/12/100);
			Double P=loanDetail.getPrincipalAmount();
			int N=loanDetail.getLoanTerm();
			Emi=((P * R * Math.pow(1+R,N)) / (Math.pow(1+R,N)-1));
			System.out.println("loanId: "+loanId + " EMI: "+Emi);
			return Emi;
		}
		throw new Exception("EMI cant be calculated") ;
	}
	
	
	public void loanRepayment(int loanId,int amount) throws InvalidLoanException{
		try {
			double emiAmount=calculateEMI(loanId);
			int noOfEmi=(int)(amount/emiAmount);
			if(amount < emiAmount || noOfEmi <=0) {
				throw new InvalidLoanException("Payment is rejected");
			}else {
				
				System.out.println("Payment successful && no of emi's paid : "+ noOfEmi);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public  Loan loanDetail(int loanId) throws InvalidLoanException {
		try {
		String q1 = "SELECT * FROM loan WHERE loanId=?";
		PreparedStatement pstmt1 =  DAO.con.prepareStatement(q1);
		
		pstmt1.setInt(1, loanId);
		
		ResultSet loanset = pstmt1.executeQuery();
		if(loanset.next()) {
		Loan loan = new Loan(loanset.getInt("loanId"),
				loanset.getInt("customerId"),
				loanset.getDouble("principalAmount"),
				loanset.getDouble("interestRate")
				,loanset.getInt("loanTerm"),
				loanset.getString("loanType"),
				loanset.getString("loanStatus"));
		return loan;
		}else {
			 throw new InvalidLoanException("Loan is not Generated.");
		}
		}catch(Exception e) {
			System.out.println("Exception is :- "+e.getMessage());
		}
		return null;
	}

	
}
