package aze.coders.cinema.dto;

import aze.coders.cinema.entity.Language;
import lombok.Data;

@Data
public class ErrorMessageTranslationDto {
    private int id;
    private Language language;
    private String message;
}
