package ch.fhnw.webec.exercise.repositories;

import ch.fhnw.webec.exercise.model.*;
import org.springframework.data.jpa.repository.*;

public interface BeanRepository extends JpaRepository<Bean, Integer> {
}
