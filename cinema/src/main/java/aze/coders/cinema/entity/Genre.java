package aze.coders.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    @JoinColumn(name = "genre")
    private List<GenreTranslation> trasnlations;
}
