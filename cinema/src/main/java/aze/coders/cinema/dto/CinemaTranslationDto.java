package aze.coders.cinema.dto;

import lombok.Data;

@Data
public class CinemaTranslationDto {
    private int id;
    private LanguageDto language;
    private String name;
}
