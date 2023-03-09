package repositories;

import domain.Cd;
import domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Cd> findByArtistAndPriceLessThan(String artist, Double price);
    List<Cd> findByArtist(String artist);
    @Query("Select c from Cd c where c.artist=:artist and c.price>:amount")
    List<Cd> getAllCdsByArtistAndPrice(String artist,Double amount);
//    @Query(value = "select * from cd where cd.artist=:artist",nativeQuery = true)
    @Query(value = "select * from product p,cd join cd on p.product_number=cd.product_number where cd.artist=:artist",nativeQuery = true)
    List<Cd> getAllCdsFromArtist(String artist);
}
