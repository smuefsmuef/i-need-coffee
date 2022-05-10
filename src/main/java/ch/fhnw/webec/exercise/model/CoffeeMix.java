package ch.fhnw.webec.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
public class CoffeeMix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    private Long pricePerKg;

    @Min(1)
    @Max(5)
    private int roastDegree;

    @NotEmpty
    @ManyToMany
    @OrderBy("origin ASC")
    private Set<Bean> beans = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coffeeMix")
    @OrderBy("createdDate DESC")
    @JsonIgnore
    private List<Rating> ratings = new ArrayList<>();


    public CoffeeMix(){ }

//    public CoffeeMix(int id, String name, Long pricePerKg, int roastDegree, Bean bean, Rating rating) {
//        this.id = id;
//        this.name = name;
//        this.pricePerKg = pricePerKg;
//        this.roastDegree = roastDegree;
//        this.beans.add(bean);
//        this.ratings.add(rating);
//    }

    public CoffeeMix(String name) {
        this();
        this.name = name;
    }

    public void addRating(Rating rating) {
        if (!this.getRatings().contains(rating)) {
            this.getRatings().add(rating);
        }
        if (rating.getCoffeeMix() != this) {
            rating.setCoffeeMix(this);
        }
    }

    // todo add something like this, adjust this one
    public double getAverageRating() {
        var averageRating = this.getRatings().stream().mapToDouble(Rating::getRating).average().orElse(0);
        return this.roundToHalf(averageRating);
    }
    private double roundToHalf(double number) {
        return Math.round(number * 2) / 2.0;
    }


    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Long pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public int getRoastDegree() {
        return roastDegree;
    }

    public void setRoastDegree(int roastDegree) {
        this.roastDegree = roastDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Bean> getBeans() {
        return beans;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

}
