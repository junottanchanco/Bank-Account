
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
//		BankAccount account2 = new BankAccount();
		System.out.println("Account #: " + account1.getAccountNumber());
		account1.deposit("checking", 100);
		account1.deposit("savings", 20);
		System.out.println("Checking Bal: $" + account1.getCheckingBal());
		System.out.println("Savings Bal: $" + account1.getSavingsBal());
		System.out.println("Total Balance: $" + account1.accountBalance());
	}

}
