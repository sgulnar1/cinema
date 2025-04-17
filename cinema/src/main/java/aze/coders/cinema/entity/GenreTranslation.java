package aze.coders.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="genre_translations")
public class GenreTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Language language;
    private String name;
    @ManyToOne
    private Genre genre;

}
