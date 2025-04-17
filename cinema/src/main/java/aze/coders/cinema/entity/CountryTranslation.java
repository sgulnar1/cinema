package aze.coders.cinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country_translations")
public class CountryTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Language language;
    private String name;
    @ManyToOne
    private Country country;
}
