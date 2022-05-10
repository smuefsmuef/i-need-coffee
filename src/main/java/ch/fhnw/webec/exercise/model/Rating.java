package ch.fhnw.webec.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Max(5)
    @NotEmpty
    private int rating;

    @NotEmpty
    private String name;

    @Column(columnDefinition = "TEXT")
    @NotEmpty
    private String review;

    private Long amount;

    @Min(1)
    @Max(10)
    private int grind;

    @CreationTimestamp
    private LocalDate createdDate;

    @ManyToOne
    @JsonIgnore
    private CoffeeMix coffeeMix;

    public Rating() {
    }

    public Rating(int rating, String name, String review) {
        this.id = id;
        this.rating = rating;
        this.name = name;
        this.review = review;
    }

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public int getGrind() {
        return grind;
    }

    public void setGrind(int grind) {
        this.grind = grind;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public CoffeeMix getCoffeeMix() {
        return coffeeMix;
    }

    public void setCoffeeMix(CoffeeMix coffeeMix) {
        this.coffeeMix = coffeeMix;
        this.coffeeMix.addRating(this);
    }

}
