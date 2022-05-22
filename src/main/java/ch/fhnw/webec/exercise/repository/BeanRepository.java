package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeanRepository extends JpaRepository<Bean, Integer> {

}
