package ch.fhnw.webec.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OrderBy;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

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

    private double averageRating;

    private int totalRatings;

    @ManyToMany
    @OrderBy("origin ASC")
    private Set<Bean> beans = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coffeeMix")
    @OrderBy("createdDateTime DESC")
    @JsonIgnore
    private List<Rating> ratings = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public CoffeeMix(){
    }

    public CoffeeMix(String name) {
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

    private double roundToHalf(double number) {
        return Math.round(number * 2) / 2.0;
    }

    // Getter & Setter

    public long getTotalRatings() {
        var total = getRatings().stream().count();
        return total;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getAverageRating() {
        var averageRating = this.getRatings().stream().mapToDouble(Rating::getRatingValue).average().orElse(0);
        return this.roundToHalf(averageRating);
    }

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
