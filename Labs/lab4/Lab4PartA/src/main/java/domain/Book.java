package domain;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int isbn;
    private String title;
    private String author;
    @ManyToOne
    @JoinTable(name = "book_publisher",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "publisher_id") })
    private Publisher publisher;
    Book(){

    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
