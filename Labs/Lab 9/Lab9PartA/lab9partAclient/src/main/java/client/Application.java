package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	RestTemplate restTemplate ;
	private String serverUrl = "http://localhost:8080/books";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// get by isbn


		System.out.println("================Get book by isbn=====================");
		Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "Book-1-11");
		System.out.println(book);

		// add Book
		System.out.println("================Adding book =====================");
		restTemplate.postForLocation(serverUrl, new Book("Book-22-2","Doe", "Advance Java with Spring boot", 344.55));

		// get book by author
		System.out.println("================Get book by author=====================");
		book= restTemplate.getForObject(serverUrl+"/author/{author}", Book.class, "Brown");
		System.out.println(book);


		// delete book with isbn Book-1-11
		System.out.println("================Deleting book by isbn=====================");
		restTemplate.delete(serverUrl+"/{isbn}", "Book-22-2");

        // get all books
		System.out.println("================Get all book =====================");
		Books books = restTemplate.getForObject(serverUrl, Books.class);
		System.out.println(books);
	}
}
