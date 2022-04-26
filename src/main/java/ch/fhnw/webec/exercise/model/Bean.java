package ch.fhnw.webec.exercise.model;

import javax.persistence.*;

@Entity
public class Bean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String type;

    @Column
    private String origin;

    @Column
    private int altitude;

    @ManyToOne(fetch = FetchType.LAZY)
    private CoffeeMix coffeeMix;

    public Bean() {
    }

    public Bean(String type, String origin, int altitude) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public CoffeeMix getCoffeeMix() {return coffeeMix;}

    public void setCoffeeMix(CoffeeMix coffeeMix) {
        this.coffeeMix = coffeeMix;
    }
}
