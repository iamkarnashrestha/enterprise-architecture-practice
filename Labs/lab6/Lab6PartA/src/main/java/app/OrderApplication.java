package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.AddressRepository;
import repositories.CustomerRepository;
import repositories.OrderRepository;
import repositories.ProductRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	AddressRepository addressRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();
		product.setName("Hibernate 3");
		product.setDescription("Good book on Hibernate");
		product.setPrice(35.50);


		OrderLine ol1 = new OrderLine(2, product);

		Product productDvd = new Dvd("Hibernat","Good book on Hibernate",34.44,"Brayan Adams");
		OrderLine oldvd = new OrderLine(2, productDvd);

		Product product2 = new Product();
		product2.setName("The best of Queen");
		product2.setDescription("Album from 1995");
		product2.setPrice(12.98);
		OrderLine ol2 = new OrderLine(4, product2);

		Product cd=new Cd("U2","Cd description",9,"U2");
		OrderLine olcd = new OrderLine(2, cd);

		Order o1 = new Order("234743", "12/10/06", "closed");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(oldvd);
		o1.addOrderLine(olcd);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"Amsterdam", "43221","USA");
		c1.addOrder(o1);
		o1.setCustomer(c1);
		orderRepository.save(o1);


		Order order=orderRepository.findById("234743").get();


		printOrder(order);


		//Method Query
		System.out.println(customerRepository.findAll());
		System.out.println(productRepository.findByArtistAndPriceLessThan("U2",10.00));

		//Named Query
		System.out.println(customerRepository.findByCountry("USA"));
		System.out.println(productRepository.findByArtist("U2"));

		//JPQL Query requests
		System.out.println(orderRepository.getOrderNumberByStatus("closed"));
		System.out.println(customerRepository.findCustomerFullNameByCity("Amsterdam"));
		System.out.println(orderRepository.getOrderNumbersBySpecificCity("Amsterdam"));
		System.out.println(productRepository.getAllCdsByArtistAndPrice("U2",4.0));

		//Native Queries
		System.out.println(addressRepository.getAddressByCity("Amsterdam"));
		System.out.println(productRepository.getAllCdsFromArtist("U2"));






	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}

	}
}
