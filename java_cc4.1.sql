-- Insert sample data into Customer table
INSERT INTO Customer (customerId, name, emailAddress, phoneNumber, address, creditScore)
VALUES
    (1, 'John Doe', 'john.doe@example.com', '123-456-7890', '123 Main St, Cityville', 750),
    (2, 'Jane Smith', 'jane.smith@example.com', '987-654-3210', '456 Oak St, Townsville', 800),
    (3, 'Bob Johnson', 'bob.johnson@example.com', '111-222-3333', '789 Maple St, Villagetown', 700),
    (4, 'Alice Brown', 'alice.brown@example.com', '444-555-6666', '321 Pine St, Hamletsville', 720),
    (5, 'Charlie Wilson', 'charlie.wilson@example.com', '777-888-9999', '555 Elm St, Boroughville', 780);

-- Insert sample data into Loan table
INSERT INTO Loan (loanId, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus)
VALUES
    (101, 1, 50000.00, 5.0, 36, 'CarLoan', 'Pending'),
    (102, 2, 200000.00, 4.5, 60, 'HomeLoan', 'Approved'),
    (103, 3, 10000.00, 6.0, 24, 'CarLoan', 'Pending'),
    (104, 4, 150000.00, 4.0, 48, 'HomeLoan', 'Approved'),
    (105, 5, 75000.00, 5.5, 36, 'CarLoan', 'Pending');

