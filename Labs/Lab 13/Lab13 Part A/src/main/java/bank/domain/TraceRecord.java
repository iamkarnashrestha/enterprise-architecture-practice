package bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private Long id;

    private long accountNumber;
    private String operation;
    private LocalDateTime dateTime;
    private double amount;

    public TraceRecord(long accountNumber, String operation, LocalDateTime dateTime, double amount) {
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public TraceRecord() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
