package domain;

import javax.persistence.Entity;

@Entity
public class Dvd extends Product{

    private String genre;

    public Dvd(){}

    public Dvd(String name, String description, double price, String genre) {
        super(name, description, price);
        this.genre = genre;
    }
}
