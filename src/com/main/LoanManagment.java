package com.main;

import java.util.Scanner;

import com.dao.DAO;
import com.dao.ILoanRepositoryImpl;
import com.entity.model.CarLoan;
import com.entity.model.HomeLoan;
import com.entity.model.Loan;
import com.exception.InvalidLoanException;

/*Create LoanManagement main class and perform following operation:
 *  main method to simulate the loan management system.
 *  Allow the user to interact with the system by entering choice from menu such as "applyLoan", "getAllLoan", "getLoan", "loanRepayment", "exit."*/

public class LoanManagment {
	
	
	
	public static void main(String[] args) throws Exception,InvalidLoanException{
		
		DAO.connect();
		
		
		
		while(true) {
			System.out.println("Welcome to Loan Managment Application ");
			System.out.println("Choose any value :");
			System.out.println("1->applyLoan");
			System.out.println("2->getAllLoan");
			System.out.println("3->getLoan");
			System.out.println("4->loanRepayment");
			System.out.println("5->Exit");
			Scanner sc = new Scanner(System.in);
			int cv = sc.nextInt();
			
		
			
			if(cv==1) {
				System.out.println("Your choice : applyLoan ");	
				
				System.out.println("Your choice Choose any value : To applyLoan ");
				System.out.println("1->Car Loan");
				System.out.println("2->Home Loan");
				int lc=sc.nextInt();
				Loan obj;
					
				System.out.println("Enter loanId");
				int loanId = sc.nextInt();
				System.out.println("Enter customerId");
				int customerId = sc.nextInt();
				System.out.println("Enter principalAmount");
				double principalAmount = sc.nextDouble();
				System.out.println("Enter interestRate");
				double interestRate = sc.nextDouble();
				System.out.println("Enter loanTerm");
				int loanTerm = sc.nextInt();
//				System.out.println("Enter loanType");
//				sc.nextLine();
//				String loanType=sc.nextLine();
				String loanStatus = "pending";
//				Loan obj= new Loan(loanId, customerId, principalAmount,interestRate, loanTerm, loanType, loanStatus) ; 
//				obj.toString();
//				new ILoanRepositoryImpl().applyLoan(obj);	
					
				if(lc==1) {
					String loanType = "CarLoan";
					sc.nextLine();
					System.out.println("Enter car model");
					String carModel = sc.nextLine();
					System.out.println("Enter car value");
					int carValue = sc.nextInt();
					 
					obj= new CarLoan(loanId, customerId, principalAmount,interestRate, loanTerm, loanType, loanStatus, carModel, carValue) ; 
					obj.toString();
					new ILoanRepositoryImpl().applyLoan(obj);
				}else if(lc==2) {
				
					String loanType="HomeLoan";
					System.out.println("Enter property address");
					String propertyAddress=sc.next();
					System.out.println("Enter property value");
					int propertyValue=sc.nextInt();
					obj=new HomeLoan(loanId, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus, propertyAddress, propertyValue);	
					obj.toString();
					new ILoanRepositoryImpl().applyLoan(obj);
				}
				else {
					System.out.println("wrong choice");
				}
			}
			
			
			
			
			else if(cv==2) {
				System.out.println("Your choice : getAllLoan ");
				new ILoanRepositoryImpl().getAllLoan();
			}
			
			
			else if(cv==3) {
				System.out.println("Your choice : getLoan");	
				System.out.println("Enter LoanID : ");
				int loanId = sc.nextInt();
				new ILoanRepositoryImpl().getLoanById(loanId);
				
			}
			else if(cv==4) {
				System.out.println("Your choice : loanRepayment ");
				System.out.println("Enter loanId ");
				int loanId = sc.nextInt();
				int amount = sc.nextInt();
				
				System.out.println("Enter Amount");
				new ILoanRepositoryImpl().loanRepayment(103,100000);
			}
			
			
			else {
				DAO.con.close();
				break;
			}
		}
		
		
	}
}
