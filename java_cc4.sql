-- CREATE DATABASE loan_managment_system;
-- USE loan_managment_system;

-- Create Customer table
CREATE TABLE Customer (
    customerId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    emailAddress VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    creditScore INT NOT NULL
);

-- Create Loan table
CREATE TABLE Loan (
    loanId INT PRIMARY KEY,
    customerId INT,
    principalAmount DECIMAL(10, 2) NOT NULL,
    interestRate DECIMAL(5, 2) NOT NULL,
    loanTerm INT NOT NULL,
    loanType VARCHAR(50) NOT NULL,
    loanStatus VARCHAR(50) NOT NULL,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);


CREATE TABLE HomeLoan (
    loanID INT PRIMARY KEY,
    propertyAddress VARCHAR(255),
    propertyValue INT,
    FOREIGN KEY (loanID) REFERENCES Loan(loanID)
);

CREATE TABLE CarLoan (
    loanID INT PRIMARY KEY,
    carModel VARCHAR(255),
    carValue INT,
    FOREIGN KEY (loanID) REFERENCES Loan(loanID)
);

