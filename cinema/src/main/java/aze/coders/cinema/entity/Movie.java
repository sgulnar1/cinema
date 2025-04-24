package aze.coders.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieTranslation> translations;
    private Date startDate;
    private Date endDate;
    @OneToMany
    private List<Country> countries;
    private Integer duration;
    @OneToMany
    private List<Genre> genres;
    @OneToOne
    private Media media;
    @ManyToMany
    private List<MovieLanguage> movieLanguages;
    @ManyToMany
    private List<Format> format;
    private Integer limitAge;
    private Integer orderNumber;
}
