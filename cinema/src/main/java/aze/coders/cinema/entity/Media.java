package aze.coders.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "medias")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String path;
}
