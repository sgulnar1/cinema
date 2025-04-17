package aze.coders.cinema.entity;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "movie_languages")
public class MovieLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    @JoinColumn(name = "movieLanguage")
    private List<MovieLanguageTranslation> movieLanguageTranslation;

}
