package repositories;

import domain.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findAll();

    List<Customer> findByCountry(String country);
    @Query("SELECT  c.firstname, c.lastname from Customer c where c.address.city=:city")
    List<String> findCustomerFullNameByCity(String city);


}
