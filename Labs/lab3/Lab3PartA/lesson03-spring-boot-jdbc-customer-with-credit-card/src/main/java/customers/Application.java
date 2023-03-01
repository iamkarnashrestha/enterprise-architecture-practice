package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerDAO customerDao;
	@Autowired
	private ProductDAO productDAO;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		System.out.println(customerDao.getCustomer(101));
		System.out.println(customerDao.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerDao.getAllCustomers());


	productDAO.clearDB();
		Product product=new Product(111,"Iphone",1200);
		Supplier supplier=new Supplier("Abc Supplier","9787667675");
		product.setSupplier(supplier);
		productDAO.save(product);
		Product product2=new Product(112,"Macbook",2000);
		Supplier supplier2=new Supplier("vyz Supplier","9787667675");
		product2.setSupplier(supplier2);
		productDAO.save(product2);
		System.out.println("Finding by product Number:"+productDAO.findByProductNumber(111));
		System.out.println("Finding by product Number:"+productDAO.findByProductNumber(112));

		System.out.println("Finding by product name Iphone:"+productDAO.findByProductName("Iphone"));
		System.out.println("Finding by product name Macbook:"+productDAO.findByProductName("Macbook"));



		System.out.println("-----------All products ----------------");
		System.out.println(productDAO.getAllProducts());
		System.out.println("Removing product");
		productDAO.removeProduct(111);

		System.out.println("-----------All products after removing----------------");
		System.out.println(productDAO.getAllProducts());



	}
}
