package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="passenger_id")
    @OrderColumn(name = "sequence")
    private List<Flight> flights;
    Passenger(){}
    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
