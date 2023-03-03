package app;

import app.repositories.*;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
//@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class OrderApplication implements CommandLineRunner{
	@Autowired
	DepartmentRepository departmentRepository;
@Autowired
	BookRepository bookRepository;
@Autowired
PublisherRepository publisherRepository;
@Autowired
PassengerRepository passengerRepository;
@Autowired
	SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department=new Department("Compro");
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(new Employee("Arjun",department));
		employees.add(new Employee("Santosh",department));
		department.setEmployee(employees);
		departmentRepository.save(department);
		System.out.println("---------------Listing Departments with Employees-----------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println(departmentRepository.findAll());

		//inserting publisher first
		publisherRepository.save(new Publisher("Abc publicaiton"));
		List<Publisher> publishers=publisherRepository.findAll();
		//inserting book with publisher
		Book book=new Book("Advance Java","Santosh Manandhar");
		book.setPublisher(publishers.get(0));
		bookRepository.save(book);

		//inserting book withoout publisher
		Book book1=new Book("More Advance Java","Arjun Subedi");
		bookRepository.save(book1);
		System.out.println("---------------Listing books-----------------");
		System.out.println("---------------------------------------------");
		System.out.println(bookRepository.findAll());

		Passenger passenger=new Passenger("Arjun");
		List<Flight> flights =new ArrayList<>();
		flights.add(new Flight("F-111","Kathmandu","Cedar Rapids", LocalDate.of(2022,11,11)));
		flights.add(new Flight("F-111","Cedar rapids","Kathmandu", LocalDate.of(2023,11,11)));
		passenger.setFlights(flights);
		passengerRepository.save(passenger);

		System.out.println("---------------Listing Passengers with flights-----------------");
		System.out.println("---------------------------------------------");
		System.out.println(passengerRepository.findAll());

		School school=new School("Maharishi International University");
		Map<Integer,Student> students= new HashMap<Integer,Student>();
		students.put(12,new Student("Karna","Shrestha"));
		students.put(13,new Student("ABC","Shrestha"));
		school.setStudents(students);
		schoolRepository.save(school);
		System.out.println("---------------Listing Schools with students-----------------");
		System.out.println("---------------------------------------------");
		System.out.println(schoolRepository.findAll());















	}


}
