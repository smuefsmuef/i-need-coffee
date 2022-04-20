package ch.fhnw.webec.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.*;


@SpringBootApplication
@EnableJpaRepositories
public class CoffeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeApplication.class, args);
    }
}
