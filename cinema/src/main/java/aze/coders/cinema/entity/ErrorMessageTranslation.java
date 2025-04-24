package aze.coders.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "error_message_translations")
public class ErrorMessageTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Language language;
    @ManyToOne
    @JsonIgnore
    private ErrorMessage errorMessage;
    private String message;
}
