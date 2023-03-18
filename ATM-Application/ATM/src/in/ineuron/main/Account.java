package in.ineuron.main;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private int balance;
    private List<Transaction> transactions;

    public Account(int id) {
        this.id = id;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(amount, "Deposit"));
        System.out.println("Deposit successfull..!");
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            System.out.println("Withdraw operation failed...!");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction(amount, "Withdraw"));
        System.out.println("Withdraw successfull...!");
    }

    public void transfer(Account other, int amount) {
    	if(other == null) {
    		System.out.println("No Account associated with the id you have provided..!");
    		System.out.println("Transfer operation failed..!");
    		return;
    	}
        if (amount > balance) {
            System.out.println("Insufficient funds");
            System.out.println("Transfer Failed.......!");
            return;
        }
        balance -= amount;
        other.deposit(amount);
        System.out.println("Transfer Successfull.........!");
        transactions.add(new Transaction(amount, "Transfer to Account " + other.getId()));
        other.transactions.add(new Transaction(amount, "Transfer from Account " + id));
    }

    public void printTransactionHistory() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDescription() + " " + transaction.getAmount());
        }
    }
}



