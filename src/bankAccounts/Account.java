package bankAccounts;

import java.time.LocalDate;

public interface Account {

	public int getAccNumber() ;

	public void setAccNumber(int accNumber) ;

	public double getBalance();
	
	public void setBalance(double balance);

	public LocalDate getOpeningDate() ;

	public double getInterestRate();

	public void setInterestRate(double interestRate) ;

	public String getType() ;

	public void setType(String type) ;

}
