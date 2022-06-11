package ch.fhnw.webec.repository;

import ch.fhnw.webec.exercise.model.*;
import ch.fhnw.webec.exercise.repository.CoffeeMixRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CoffeeMixRepositoryIT {

    private static final String COFFEE_MIX_NAME = "Test";

    private final CoffeeMixRepository coffeeMixRepository;

    CoffeeMixRepositoryIT(@Autowired CoffeeMixRepository coffeeMixRepository) throws IOException {
        this.coffeeMixRepository = coffeeMixRepository;
    }

    @Test
    void testFindById() {
        var coffeeMix = createCoffeeMix();
        coffeeMixRepository.save(coffeeMix);
        var coffeeMixFromRepo = coffeeMixRepository.findById(coffeeMix.getId()).orElse(null);
        assertEquals(coffeeMix.getName(), coffeeMixFromRepo.getName());
        assertEquals(coffeeMix.getId(), coffeeMixFromRepo.getId());
        coffeeMixRepository.deleteAll();
    }

    @Test
    void testInsertAndGet() {
        var size = coffeeMixRepository.findAll().size();
        coffeeMixRepository.save(createCoffeeMix());
        var coffeeMixes = coffeeMixRepository.findAll();
        assertEquals(size + 1, coffeeMixes.size());
        assertEquals(COFFEE_MIX_NAME, coffeeMixes.get(coffeeMixRepository.findAll().size() - 1).getName());
        coffeeMixRepository.deleteAll();
    }

    @Test
    public void testDeleteCoffeeMix() {
        var coffeeMix = createCoffeeMix();
        this.coffeeMixRepository.save(coffeeMix);
        var size = coffeeMixRepository.findAll().size();
        this.coffeeMixRepository.delete(coffeeMix);
        assertEquals(size - 1, this.coffeeMixRepository.findAll().size());
    }

    @Test
    public void TestUpdateCoffeeMix() {
        var coffeeMix = createCoffeeMix();
        assertEquals(COFFEE_MIX_NAME, coffeeMix.getName());
        coffeeMix.setName("Test1");
        var savedCoffeeMix = coffeeMixRepository.save(coffeeMix);
        assertEquals("Test1", savedCoffeeMix.getName());
        coffeeMixRepository.deleteAll();
    }

    private CoffeeMix createCoffeeMix() {
        var coffeeMix = new CoffeeMix(COFFEE_MIX_NAME);
        coffeeMix.setRoastDegree(1);
        return coffeeMix;
    }
}
