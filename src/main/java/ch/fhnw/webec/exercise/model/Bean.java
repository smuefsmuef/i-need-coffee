package ch.fhnw.webec.exercise.model;

import ch.fhnw.webec.exercise.form.BeanOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Bean implements BeanOption {

    // todo implement select

    @Id
    private Long id;

    private String type;

    private String origin;

    private int altitude;

    @Override
    @JsonIgnore
    public String getValue() {
        return String.valueOf(this.getId());
    }

    @Override
    @JsonIgnore
    public String getLabel() {
        return this.getType();
    }

    // Getter & Setter

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

}
