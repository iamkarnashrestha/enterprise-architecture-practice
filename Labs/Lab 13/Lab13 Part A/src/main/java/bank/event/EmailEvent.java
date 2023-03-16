package bank.event;

public class EmailEvent {
        private long accountNumber;
    private double amount;
    private String operation;

    public EmailEvent(long accountNumber, double amount, String operation) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.operation = operation;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getOperation() {
        return operation;
    }
}
