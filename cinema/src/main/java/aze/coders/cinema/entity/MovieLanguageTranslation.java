package aze.coders.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="movie_language_translations")
public class MovieLanguageTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Language language;
    private String lang;
    @ManyToOne
    @JsonIgnore
    private MovieLanguage movieLanguage;
}
