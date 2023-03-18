package in.ineuron.test;

import java.util.Scanner;

import in.ineuron.main.Account;
import in.ineuron.main.AccountHolder;
import in.ineuron.main.Bank;

public class ATM {
	
	private AccountHolder accountHolder;
	private Account account;
	private Bank bank;
	
	public ATM(Bank bank,Account account) {
		this.bank = bank;
		this.account=account;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void start() {
		System.out.println("Welcome to the ATM. Please enter your ID and PIN:");
		int id = scanner.nextInt();
		int pin = scanner.nextInt();
		accountHolder = new AccountHolder(id, pin);
		if (authenticate(accountHolder)) {
			showMenu();
		} else {
			System.out.println("Invalid ID or PIN. Exiting.");
		}
	}

	private boolean authenticate(AccountHolder accountHolder) {
		// Dummy authentication for demonstration purposes
		return accountHolder.getId() == 1234 && accountHolder.getPin() == 5678;
	}

	private void showMenu() {
		while (true) {
			System.out.println("\nPlease select an option:");
			System.out.println("1. Show transactions history");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Transfer");
			System.out.println("5. ShowBalance");
			System.out.println("6. Quit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				account.printTransactionHistory();
				break;
			case 2:
				System.out.print("Enter amount to withdraw :: ");
				int withdrawAmount=scanner.nextInt();
				account.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.print("Enter amount to Deposit :: ");
				int depositAmount=scanner.nextInt();
				account.deposit(depositAmount);
				break;
			case 4:
				System.out.print("Enter id of the account to transfer money :: ");
				int id=scanner.nextInt();
				System.out.println("Enter amount which needs to be transferred :: ");
				int transferAmount=scanner.nextInt();
				Account account2 = bank.getAccountById(id);
				account.transfer(account2,transferAmount);
				break;
			case 5:
				System.out.println("The current balance is :: "+account.getBalance());
				break;
			case 6:
				System.out.println("Thank you for using the ATM. Goodbye!");
						return;
			default:
				System.out.println("Invalid choice. Please try again.");
						break;
			}
		}
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
	    Account account1 = new Account(1);
	    Account account2 = new Account(2);
	    bank.addAccount(account1);
	    bank.addAccount(account2);

	    ATM atm = new ATM(bank,account1);
	    atm.start();
	}
}