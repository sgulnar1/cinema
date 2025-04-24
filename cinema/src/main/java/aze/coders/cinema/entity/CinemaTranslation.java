package aze.coders.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cinema_translations")
public class CinemaTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Language language;
    @ManyToOne
    @JsonIgnore
    private Cinema cinema;
    private String name;
}
