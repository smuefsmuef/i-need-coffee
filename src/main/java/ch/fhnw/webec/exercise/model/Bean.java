package ch.fhnw.webec.exercise.model;

import ch.fhnw.webec.exercise.form.BeanOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Bean implements BeanOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String origin;

    private int altitude;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

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

    // todo make sure the name is unique
}
