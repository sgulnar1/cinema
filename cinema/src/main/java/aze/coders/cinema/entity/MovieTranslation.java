package aze.coders.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "movie_translations")
public class MovieTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    private Movie movie;
    @ManyToOne
    private Language language;
    private String name;
    private String director;
    private String actors;
    private String description;

}
