package kafka;

public class TransactionRequestDTO {

    private long accountNumber;
    private Double amount;
    private Long fromAccountNumber;
    private Long toAccountNumber;
    private String description;
    public TransactionRequestDTO(){

    }
    public TransactionRequestDTO(Long accountNumber, Double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public TransactionRequestDTO( Long fromAccountNumber, Long toAccountNumber,Double amount, String description) {
        this.amount = amount;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.description = description;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public String getDescription() {
        return description;
    }
}
