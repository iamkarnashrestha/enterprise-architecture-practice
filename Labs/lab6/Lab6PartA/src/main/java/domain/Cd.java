package domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Cd.findByArtist",query="select c from Cd c where c.artist=:artist")
public class Cd extends Product{
    private String artist;
public Cd(){}

    public Cd(String name, String description, double price, String artist) {
        super(name, description, price);
        this.artist = artist;
    }

    @Override
    public String toString() {
        return super.toString()
        +"Cd{" +
                "artist='" + artist + '\'' +
                '}';
    }
}
