package bankAccounts;

public interface Service {

	//here will be placed all methods for all kinds of transactions with the accounts
	
	public void deposit(double amount);
	
	public void withdraw(double amount);
	
	public void transfer(Account acc, double amount);
	
	public double accrueInterestRate(int days);
	
}
