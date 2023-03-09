package domain;

import javax.persistence.Entity;

@Entity
public class Book extends Product{

    private String isbn;

    public Book() {
    }

    public Book(String name, String description, double price,String isbn) {
        super(name, description, price);
        this.isbn=isbn;
    }
}
