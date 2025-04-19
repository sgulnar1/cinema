package aze.coders.cinema.dto;

import lombok.Data;

import java.util.List;

@Data
public class CinemaResponseDto {
    private Integer id;
    private List<CinemaTranslationResponseDto> translations;
    private Integer orderNumber;
    private Boolean all;
}
