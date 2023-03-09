package repositories;

import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {

    @Query("SELECT o.ordernr from Order o where o.status=:status")
    List<String> getOrderNumberByStatus(String status);
@Query("select o.ordernr from Order o where o.customer.address.city=:city")
    List<String> getOrderNumbersBySpecificCity(String city);
}
