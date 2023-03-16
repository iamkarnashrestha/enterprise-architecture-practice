package bank.event;

public class TraceRecordEvent {
    private long accountNumber;
    private double amount;
    private String operation;
    public TraceRecordEvent(){}
    public TraceRecordEvent(long accountNumber, double amount, String operation) {
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

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
