package bankAccounts;

import java.time.LocalDate;

public class BankAccount implements Account, Service {

	public int accNumber;
	public double balance;
	public LocalDate openingDate;
	public double interestRate;
	public String type;
	
	public BankAccount(int accNumber, double balance, LocalDate openingDate, 
			double interestRate, String type) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.openingDate = openingDate;
		this.interestRate = interestRate;
		this.type = type;	
	}
	
	@Override
	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
		} else {
			System.out.println("You cannot deposit 0 or negative amount.\nEnter amount again?\nY/N");
		}
		
	}

	@Override
	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Invalid operation."
					+ "The amount withdrawn cannot be bigger than the current balance.");
		} else if (amount <= 0) {
			System.out.println("Invalid operation. The amount withdrawn cannot be 0 or negative number.");
		} else {
			balance = balance - amount;
		}		
	}

	@Override
	public void transfer(Account destAcc, double amount) {
		if (accNumber == destAcc.getAccNumber()) {
			System.out.println("Cannot transfer amount to the same account");
		} else if (amount > balance) {
			System.out.println("Invalid operation."
					+ "The amount withdrawn cannot be bigger than the current balance.");
		} else if (amount <= 0) {
			System.out.println("Invalid operation. The amount withdrawn cannot be 0 or negative number.");
		} else {
			balance = balance - amount;
			destAcc.setBalance(destAcc.getBalance() + amount);
		}		
	}

	@Override
	public double accrueInterestRate(int years) {
		
		return balance = balance * (1 + ((interestRate / 100) * years));		

	}

	@Override
	public int getAccNumber() {
		return accNumber;
	}

	@Override
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;		
	}

	@Override
	public double getBalance() {
		return balance;
	}
	
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public LocalDate getOpeningDate() {
		return openingDate;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;		
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;		
	}

}
