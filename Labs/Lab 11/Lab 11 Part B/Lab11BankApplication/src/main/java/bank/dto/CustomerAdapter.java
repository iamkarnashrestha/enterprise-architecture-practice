package bank.dto;

import bank.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getName()
        );
    }
    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer){
        return new CustomerDTO(customer.getName());
    }
    public static List<CustomerDTO> getCustomerDTOsFromCustomers(List<Customer> customers){
        List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
        for (Customer customer: customers){
            customerDTOs.add(getCustomerDTOFromCustomer(customer));
        }
        return customerDTOs;
    }
}
