package repositories;

import domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying
    @Query("update Book b set b.locationCode=:locationCode+b.locationCode")
    int update(String locationCode);


    @Transactional
    @Modifying
    @Query("Delete Book b where b.publicationYear<1950")
    int removeBooksBefore1950();



}
