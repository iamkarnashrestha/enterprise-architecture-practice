package customers;

import customers.student.Address;
import customers.student.Grade;
import customers.student.Student;
import customers.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer
//		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
//		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
//		creditCard = new CreditCard("657483342", "Visa", "09/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
//		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		//get customers
//		System.out.println(customerRepository.findById(66).get());
//		System.out.println(customerRepository.findById(101).get());
//		System.out.println("-----------All customers ----------------");
//		System.out.println(customerRepository.findAll());
//		//update customer
//		customer = customerRepository.findById(101).get();
//		customer.setEmail("jd@gmail.com");
//		customerRepository.save(customer);
//		System.out.println("-----------find by phone ----------------");
//		System.out.println(customerRepository.findByPhone("0622341678"));
//		System.out.println("-----------find by email ----------------");
//		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
//		System.out.println("-----------find customers with a certain type of creditcard ----------------");
//		List<Customer> customers = customerRepository.findCustomerWithCreditCardType("Visa");
//		for (Customer cust : customers){
//			System.out.println(cust);
//		}




		//For Students

		List<Grade> gradeListkarna=new ArrayList<>();
		gradeListkarna.add(new Grade("MPP","A+"));
		gradeListkarna.add(new Grade("MWA","A"));
		List<Grade> gradeListarjun=new ArrayList<>();
		gradeListarjun.add(new Grade("MPP","A"));
		gradeListarjun.add(new Grade("FPP","A-"));
		List<Grade> gradeListsantosh=new ArrayList<>();
		gradeListsantosh.add(new Grade("MPP","B"));
		gradeListsantosh.add(new Grade("Cloud","B-"));




		Student karna=new Student("Karna Shrestha","87457756",new Address("100 N 4th","Fairfield",52557),gradeListkarna);
		Student arjun=new Student("Arjun Subedi","87457756",new Address("100 N 4th","Ottuma",52557),gradeListarjun);
		Student santosh=new Student("SantoshS Manandhar","874577",new Address("100 N 4th","Sigourney",52557),gradeListsantosh);

		//Saving students
//		studentRepository.save(karna);
//		studentRepository.save(arjun);
//		studentRepository.save(santosh);

//		Find the Students with a certain name
		System.out.println("=============Find Students by Name================");
		System.out.println(studentRepository.findStudentsByName("Karna Shrestha"));
//• Find the Students with a certain phone number
		System.out.println("=============Find Students by Phone number================");
		System.out.println(studentRepository.findStudentsByPhone("87457756"));

//• Find the Students from a certain city using @query
		System.out.println("=============Find Students by City ================");
		System.out.println(studentRepository.findStudentsByCity("Ottuma"));


//		• Find the Students that took a certain course with a given name
		System.out.println("=============Find Students by City ================");
		System.out.println(studentRepository.findStudentsByCourseName("Cloud"));

//• Find the Students with an A+ for a certain course name

		System.out.println("=============Find Students by Course name and grade ================");
		System.out.println(studentRepository.findStudentsByCourseAndGrade("MPP"));



	}

}
