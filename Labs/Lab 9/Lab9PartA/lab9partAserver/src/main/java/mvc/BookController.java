package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class BookController {
    private Map<String, Book> books = new HashMap<String, Book>();
    public BookController() {
        books.put("Book-1-11", new Book("Book-1-11", "Brown", "Advance Java", 300.44));
        books.put("Book-1-99", new Book("Book-1-99", "Jones", "Java with Spring", 890.3));
    }
    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        books.put(book.getIsbn(), book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) {
        books.put(isbn, book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        books.remove(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= "
                    + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        Books allbooks = new Books(books.values());
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }

    @GetMapping("/books/author/{author}")
    public ResponseEntity<?> searchBooks(@PathVariable String author) {
        Book book=new Book();
        for(String key : books.keySet()){
            Book value = books.get(key);
            if(value.getAuthor().equals(author)){
                book=value;
                break;
            }
            else {
                book=null;
            }
        }
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with author= "
                    + author + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
