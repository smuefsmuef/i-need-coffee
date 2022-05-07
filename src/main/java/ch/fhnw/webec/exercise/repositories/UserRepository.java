package ch.fhnw.webec.exercise.repositories;

import ch.fhnw.webec.exercise.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
