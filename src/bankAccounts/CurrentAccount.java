package bankAccounts;

import java.time.LocalDate;

public class CurrentAccount extends BankAccount {
	
	// Current account is account for active usage assuming that customers will need
	// to make operations frequently
	// It has no interest rate and no term date
	
	double interestRate = 0;
	
	public CurrentAccount(int accNumber, double balance, LocalDate openingDate, 
							double interestRate, String type) {
		super(accNumber, balance, openingDate, interestRate, type);
	}
	
	@Override
	public double accrueInterestRate(int days) {
		
		System.out.println("Current account type has no interest rate");
		
		return balance;
	}
	
}
