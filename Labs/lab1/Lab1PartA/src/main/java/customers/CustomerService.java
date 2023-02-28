package customers;

public class CustomerService implements ICustomerService {
	ICustomerDAO customerDAO ;
	IEmailSender emailSender ;

	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}

	//setter injection for customerDAO
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO=customerDAO;
	}
	//setter injection for emailSender
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender=emailSender;
	}
}
