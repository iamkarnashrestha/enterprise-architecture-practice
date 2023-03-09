package bank.domain;

import org.aspectj.weaver.tools.Trace;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class TraceRecord {


    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;
    private LocalTime time;
    private String result;
    public TraceRecord(){}

    public TraceRecord(LocalDate date, LocalTime time,String result
    ) {
        this.date = date;
        this.time = time;
        this.result=result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
