package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Locale;@Entity
public class Flight {
    @Id
    @GeneratedValue
    private int id;
    private String flightnumber;
    @Column(name="flight_from")
    private String from;
    @Column(name="flight_to")
    private String to;
    private LocalDate date;

    Flight(){

    }


    public Flight(String flightnumber, String from, String to, LocalDate date) {
        this.flightnumber = flightnumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightnumber='" + flightnumber + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                '}';
    }
}
