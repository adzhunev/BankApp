package bankAccounts;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
	
	// Deposit account is account for keeping savings.
	// It has interest rate
	// Customers can withdraw money only on the term date
	
	private LocalDate termDate;
	
	public DepositAccount(int accNumber, double balance, LocalDate openingDate, 
							double interestRate, String type, LocalDate termDate) {
		super(accNumber, balance, openingDate, interestRate, type);
		this.termDate = termDate;
	}

	public LocalDate getTermDate() {
		return termDate;
	}

	public void setTermDate(LocalDate termDate) {
		this.termDate = termDate;
	}

	@Override
	public void withdraw(double amount) {
		
		LocalDate currentDate = LocalDate.now();
		
		if (currentDate == termDate) {
			if (amount > balance) {
				System.out.println("Invalid operation. "
						+ "The amount withdrawn cannot be bigger than the current balance.");
			} else if (amount <= 0) {
				System.out.println("Invalid operation. "
						+ "The amount withdrawn cannot be 0 or negative number.");
			} else {
				balance = balance - amount;
			}
		} else {
			System.out.println("Withdrawal from this account can be made only on the term date");
		}
	}
	
	@Override
	public void transfer(Account destAcc, double amount) {
		
		LocalDate currentDate = LocalDate.now();
		
		if (currentDate != termDate) {
			if (this.accNumber == destAcc.getAccNumber()) {
				System.out.println("Cannot transfer amount to the same account");
			} else if (amount > balance) {
				System.out.println("Invalid operation. "
						+ "The amount withdrawn cannot be bigger than the current balance.");
			} else if (amount <= 0) {
				System.out.println("Invalid operation. "
						+ "The amount withdrawn cannot be 0 or negative number.");
			} else {
				balance = balance - amount;
				destAcc.setBalance(destAcc.getBalance() + amount);
			}
		} else {
			System.out.println("Transfer from this account can be made only on the term date");
		}		
	}
	
}


