package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.*;
import org.springframework.data.jpa.repository.*;

public interface CoffeeMixRepository extends JpaRepository<CoffeeMix, Integer> {
}

