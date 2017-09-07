import java.util.*;

//	Create a BankAccount class
//	The class should have the following attributes: (string) account number, 
//	(double) checking balance, (double) savings balance.
public class BankAccount {
	private String accountNumber;
	private double checkingBalance = 0;
	private double savingsBalance;
//	Create a class member (static) that has the number of accounts created thus far.
	private static int numberOfAccounts = 0;
//	Create a class member (static) that tracks the total amount of money stored in every account created.
	private static int totalMoney = 0;
	
	
//	In the constructor, call the private method from above so that each user has a random ten digit account.
//	In the constructor, be sure to increment the account count.
	public BankAccount() {
		this.accountNumber = generateAccount();
		numberOfAccounts++;
	}
	
//	Create a private method that returns a random ten digit account number.
	private String generateAccount() {
		String acc = "";
		int max = 10;
		int min = 0;
		
		for(int i = 0; i < 10; i++) {
			int random = (int)(Math.random()*max+min);
			acc = acc.concat(String.valueOf(random));
		}
		return acc;
	}
//	Create a getter method for the user's Account number.
	public String getAccountNumber() {
		return this.accountNumber;
	}
//	Create a getter method for the user's checking account balance.
	public double getCheckingBal() {
		return this.checkingBalance;
	}
//	Create a getter method for the user's savings account balance.
	public double getSavingsBal() {
		return this.savingsBalance;
	}
//	 Create a method that will allow a user to deposit money into either the checkings or savings, 
//	be sure to add to total amount stored.
	public void deposit(String accountType, double amount) {
		String acc = accountType.toLowerCase();
		
		if(acc.equals("checking")) {
			this.checkingBalance += amount;
			totalMoney += amount;
		}else if(acc.equals("savings")){
			this.savingsBalance += amount;
			totalMoney += amount;
		}else {
			System.out.println("Could not find account with that name.");
		}
	}
//	Create a method to withdraw money from one balance. Do not allow them to withdraw money 
//	if there are insufficient funds.
	public void withdraw(String accountType, double amount) {
		String acc = accountType.toLowerCase();
		
		if(acc.equals("checking")) {
			if(this.checkingBalance - amount < 0) {
				System.out.println("Cannot withdraw. INSUFFICIENT FUNDS.");
			}else {
				this.checkingBalance -= amount;
				totalMoney -= amount;
			}
		}else if(acc.equals("savings")) {
			if(this.savingsBalance - amount < 0) {
				System.out.println("Cannot withdraw. INSUFFICIENT FUNDS.");
			}else {
				this.savingsBalance -= amount;
				totalMoney -= amount;
			}
		}else {
			System.out.println("Could not find account with that name.");
		}
	}
//	Create a method to see the total money from the checkings and savings.
	public double accountBalance() { //setter
		double total = this.checkingBalance + this.savingsBalance;
		return total; 
	}
	public static double getTotalMoney() { //getter
		return totalMoney; 
	}
	public static int getNumberOfAccounts() { //getter
		return numberOfAccounts;
	}
}
