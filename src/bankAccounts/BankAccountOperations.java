package bankAccounts;

import java.time.LocalDate;

public class BankAccountOperations {

	public static void main(String[] args) {
		String[] types = { "current", "deposit", "undefined" };
		LocalDate ldt = LocalDate.now();
		LocalDate setLDT = LocalDate.of(2021, 05, 24);
		LocalDate setldt = LocalDate.parse("2021-04-05");

		// System.out.println("Set 1st date: " + setLDT);
		System.out.println("Set 2nd date: " + setldt);

		CurrentAccount custAcc1 = new CurrentAccount(01, 0, ldt, 0.0, types[0]);
		DepositAccount custAcc2 = new DepositAccount(02, 0, ldt, 0.2, types[1], setldt);
		DepositAccount custAcc3 = new DepositAccount(03, 0, ldt, 0.2, types[1], setldt);

		custAcc3.setTermDate(setLDT);
		System.out.println("customer 3 term date: " +custAcc3.getTermDate());
		  
		System.out.println("customer 1 acc type: " + custAcc1.getType());
		System.out.println("customer 2 acc type: " + custAcc2.getType());		  
		System.out.println("customer 3 acc type: " + custAcc3.getType());
		System.out.println("customer 3 opening date: " + custAcc3.getOpeningDate()); 

		// make deposit
		custAcc1.deposit(1000);
		System.out.println("customer 1 balance: " + custAcc1.getBalance());
		custAcc2.deposit(1000);
		System.out.println("customer 2 balance: " + custAcc2.getBalance());
		 
		// calculate interest rate for a period of n years
		System.out.println("calculate interest rate " + custAcc2.accrueInterestRate(1));
		System.out.println(custAcc1.getOpeningDate());
		
		// try to transfer money from one account to another
		custAcc1.transfer(custAcc2, 500);
		System.out.println("balance after transfer: ");
		System.out.println("customer 1: " + custAcc1.getBalance());
		System.out.println("customer 2: " + custAcc2.getBalance());
		
		custAcc3.deposit(1000);
		custAcc3.transfer(custAcc1, 500);
		System.out.println("customer 1: " + custAcc1.getBalance());
		System.out.println("customer 3: " + custAcc3.getBalance());
		
		// transfer money between deposit accounts
		DepositAccount from = new DepositAccount(02, 1000, ldt, 0.2, types[1], ldt);	
		DepositAccount to = new DepositAccount(03, 100, ldt, 0.2, types[1], ldt);
		System.out.println(from.getTermDate());
		System.out.println(to.getTermDate());
		from.transfer(to, 500);
		System.out.println(from.getBalance());
		System.out.println(to.getBalance());
	}

}
