package ch.fhnw.webec.exercise.repositories;

import ch.fhnw.webec.exercise.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByCoffeeMixId(int id);
}
