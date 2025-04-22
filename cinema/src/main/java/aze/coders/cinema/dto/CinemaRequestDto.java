package aze.coders.cinema.dto;

import lombok.Data;

import java.util.List;

@Data
public class CinemaRequestDto {
    private List<CinemaTranslationRequestDto> translations;
    private Integer orderNumber;
    private Boolean allItems;
}
