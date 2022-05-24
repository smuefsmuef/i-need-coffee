package ch.fhnw.webec.model;

import ch.fhnw.webec.exercise.model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoffeeMixUnitTest {

    @Test
    public void testAddRating() {
        var coffeeMix = new CoffeeMix();
        var rating = new Rating();

        assertEquals(0, coffeeMix.getRatings().size());

        coffeeMix.addRating(rating);

        assertEquals(1, coffeeMix.getRatings().size());
        assertTrue(coffeeMix.getRatings().contains(rating));
        assertEquals(coffeeMix, rating.getCoffeeMix());
    }

    @Test
    public void testRemoveRating() {
        var coffeeMix = new CoffeeMix();
        var rating = new Rating();

        assertEquals(0, coffeeMix.getRatings().size());

        coffeeMix.addRating(rating);

        assertEquals(1, coffeeMix.getRatings().size());
        assertTrue(coffeeMix.getRatings().contains(rating));
        assertEquals(coffeeMix, rating.getCoffeeMix());

        coffeeMix.getRatings().remove(rating);

        assertEquals(0, coffeeMix.getRatings().size());
        assertTrue(coffeeMix.getRatings().isEmpty());
    }

    @Test
    public void testAddBean() {
        var coffeeMix = new CoffeeMix();
        var bean = new Bean();

        assertEquals(0, coffeeMix.getBeans().size());

        coffeeMix.getBeans().add(bean);

        assertEquals(1, coffeeMix.getBeans().size());
        assertTrue(coffeeMix.getBeans().contains(bean));
    }

    @Test
    public void testRemoveBean() {
        var coffeeMix = new CoffeeMix();
        var bean = new Bean();

        assertEquals(0, coffeeMix.getBeans().size());

        coffeeMix.getBeans().add(bean);

        assertEquals(1, coffeeMix.getBeans().size());
        assertTrue(coffeeMix.getBeans().contains(bean));

        coffeeMix.getBeans().remove(bean);

        assertEquals(0, coffeeMix.getBeans().size());
        assertTrue(coffeeMix.getBeans().isEmpty());
    }

    @Test
    public void testGetAverageRating() {
        var coffeeMix = new CoffeeMix();
        var rating1 = new Rating(5);
        var rating2 = new Rating(2);
        var rating3 = new Rating(4);
        var rating4 = new Rating(4);

        coffeeMix.addRating(rating1);
        coffeeMix.addRating(rating2);
        coffeeMix.addRating(rating3);

        assertEquals(3.5, coffeeMix.getAverageRating());

        coffeeMix.addRating(rating4);

        assertEquals(4, coffeeMix.getAverageRating());
    }


}
