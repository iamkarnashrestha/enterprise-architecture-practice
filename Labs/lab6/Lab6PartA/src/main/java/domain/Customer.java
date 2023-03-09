package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@NamedQuery(name="Customer.findByCountry", query="select c from Customer c where c.address.country = :country")
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Address address;
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	private Collection<Order> theOrders = new ArrayList<Order>();

	public Customer() {
	}

	public Customer(String firstname, String lastname, String street,
			String city, String zip,String country) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = new Address(street, city, zip,country);
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Collection<Order> getTheOrders() {
		return Collections.unmodifiableCollection(theOrders);
	}

	
	public boolean addOrder(Order order) {
		boolean added = theOrders.add(order); 
		if (added) {
			order.setCustomer(this);
		}
		return added;
	}

	public boolean removeOrder(Order order) {
		boolean removed = theOrders.remove(order);
		if (removed) {
			theOrders.remove(order);
		}
		return removed;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", address=" + address +
//				", theOrders=" + theOrders +
				'}';
	}
}
