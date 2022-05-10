package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface CoffeeMixRepository extends JpaRepository<CoffeeMix, Integer> {
// tododelete
//    @Query("""
//        SELECT DISTINCT coffeemix FROM CoffeeMix coffeemix
//        INNER JOIN coffeemix.beans bean
//        WHERE lower(coffeemix.beans) LIKE lower(concat('%', :search, '%'))
//            OR lower(coffeemix.roastDegree) LIKE lower(concat('%', :search, '%'))
//            OR lower(coffeemix.pricePerKg) LIKE lower(concat('%', :search, '%'))
//            """)

  // List<CoffeeMix> findBySearch(@Param("search") String search);

}

//
//    @Query("""
//        SELECT DISTINCT book FROM Book book
//        INNER JOIN book.topics topic
//        WHERE lower(book.title) LIKE lower(concat('%', :search, '%'))
//            OR lower(book.description) LIKE lower(concat('%', :search, '%'))
//            OR lower(topic.name) LIKE lower(concat('%', :search, '%'))
//    """)
//    List<Book> findBySearch(@Param("search") String search);
