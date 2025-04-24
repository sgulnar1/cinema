package aze.coders.cinema.dto;

import lombok.Data;

import java.util.List;

@Data
public class CinemaDto {
    private Integer id;
    private List<CinemaTranslationDto> translations;
    private Integer orderNumber;
    private Boolean allItems;
}
