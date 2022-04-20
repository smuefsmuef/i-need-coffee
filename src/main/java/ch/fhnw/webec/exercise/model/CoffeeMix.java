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
    private Long pricePerKg;

    @Column
    @Min(1)
    @Max(5)
    private int roastDegree;

    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "coffeeMix")
    private final List<Bean> bean = new ArrayList<>();

    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "coffeeMix")
    private final List<Rating> rating = new ArrayList<>();

    public CoffeeMix(){

    }

    public CoffeeMix(Long id, Long pricePerKg, int roastDegree, Bean bean, Rating rating) {
        this.id = id;
        this.pricePerKg = pricePerKg;
        this.roastDegree = roastDegree;
        this.bean.add(bean);
        this.rating.add(rating);
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
}
