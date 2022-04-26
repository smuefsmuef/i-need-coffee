package ch.fhnw.webec.exercise.dto;

import ch.fhnw.webec.exercise.model.*;

import java.util.*;

public class CoffeeMixDto {

    private long pricePerKg;
    private int roastDegree;
    private List<Bean> beans;
    private List<Rating> ratings;

    public long getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(long pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public int getRoastDegree() {
        return roastDegree;
    }

    public void setRoastDegree(int roastDegree) {
        this.roastDegree = roastDegree;
    }

    public List<Bean> getBeans() {
        return beans;
    }

    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
