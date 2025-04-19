package aze.coders.cinema.service;

import aze.coders.cinema.dto.CinemaRequestDto;
import aze.coders.cinema.dto.CinemaResponseDto;

import java.util.List;

public interface CinemaService {
    List<CinemaResponseDto> getCinemas();
    CinemaResponseDto getCinemaById(Integer id);
    CinemaResponseDto createCinema(CinemaRequestDto cinemaRequestDto);
    void deleteCinema(Integer id);
    CinemaResponseDto updateCinema(Integer id, CinemaRequestDto cinemaRequestDto);
}
