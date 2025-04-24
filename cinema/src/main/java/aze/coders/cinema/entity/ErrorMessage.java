package aze.coders.cinema.entity;

import aze.coders.cinema.enums.ErrorCode;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "error_messages")
public class ErrorMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ErrorCode errorCode;
    @OneToMany(mappedBy = "errorMessage", cascade = CascadeType.ALL)
    private List<ErrorMessageTranslation> translations;
}
