package in.ineuron.main;


public class Transaction {
    private int amount;
    private String description;

    public Transaction(int amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}

