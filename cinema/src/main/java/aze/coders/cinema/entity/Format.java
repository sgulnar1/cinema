package aze.coders.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "formats")
@Data
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
