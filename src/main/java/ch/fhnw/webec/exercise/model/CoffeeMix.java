package ch.fhnw.webec.exercise.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
public class CoffeeMix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Long pricePerKg;

    @Column
    @Min(1)
    @Max(5)
    private int roastDegree;

    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "coffeeMix")
    private final List<Bean> beans = new ArrayList<>();

    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "coffeeMix")
    private final List<Rating> ratings = new ArrayList<>();

    public CoffeeMix(){

    }

    public CoffeeMix(Long id, String name, Long pricePerKg, int roastDegree, Bean bean, Rating rating) {
        this.id = id;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.roastDegree = roastDegree;
        this.beans.add(bean);
        this.ratings.add(rating);
    }

    public CoffeeMix addBean(Bean bean) {
        this.beans.add(bean);
        bean.setCoffeeMix(this);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Bean> getBeans() {
        return beans;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
}
