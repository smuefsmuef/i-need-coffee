package ch.fhnw.webec.exercise.model;

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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @Min(1)
    @Max(10)
    private int rating;

    @NotEmpty
    private String name;

    @Column(columnDefinition = "TEXT")
    private String review;

    @Column
    private Long amount;

    @Column
    @Min(1)
    @Max(5)
    private int grind;

    @CreationTimestamp
    private LocalDate createdDate;

    @ManyToOne
    private CoffeeMix coffeeMix;

    public Rating() {

    }

    public Rating(Long id, int rating, String name, String review, Long amount, int grind) {
        this.id = id;
        this.rating = rating;
        this.name = name;
        this.review = review;
        this.amount = amount;
        this.grind = grind;
    }


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
    }
}
