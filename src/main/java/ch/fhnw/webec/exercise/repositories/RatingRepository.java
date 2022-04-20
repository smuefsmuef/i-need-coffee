package ch.fhnw.webec.exercise.repositories;

import ch.fhnw.webec.exercise.model.*;
import org.springframework.data.jpa.repository.*;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
