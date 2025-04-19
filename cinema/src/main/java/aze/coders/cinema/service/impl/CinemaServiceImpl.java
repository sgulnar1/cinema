package aze.coders.cinema.service.impl;

import aze.coders.cinema.dto.CinemaRequestDto;
import aze.coders.cinema.dto.CinemaResponseDto;
import aze.coders.cinema.entity.Cinema;
import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.exception.NotFoundException;
import aze.coders.cinema.repository.CinemaRepository;
import aze.coders.cinema.service.CinemaService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private ObjectMapper mapper;

    @Override
    public List<CinemaResponseDto> getCinemas() {
        return mapper.convertValue(cinemaRepository.findAll(), new TypeReference<List<CinemaResponseDto>>() {
        });
    }

    @Override
    public CinemaResponseDto getCinemaById(Integer id) {
        return mapper.convertValue(findById(id), CinemaResponseDto.class);
    }

    @Override
    public CinemaResponseDto createCinema(CinemaRequestDto cinemaRequestDto) {
        return mapper.convertValue(cinemaRepository.save(mapper.convertValue(cinemaRequestDto, Cinema.class)), CinemaResponseDto.class);
    }

    @Override
    public void deleteCinema(Integer id) {
        findById(id);
        cinemaRepository.deleteById(id);
    }

    @Override
    public CinemaResponseDto updateCinema(Integer id, CinemaRequestDto cinemaRequestDto) {
        Cinema findCinema = findById(id);
        Cinema cinema = mapper.convertValue(cinemaRequestDto, Cinema.class);
        cinema.setId(findCinema.getId());
        return mapper.convertValue(cinemaRepository.save(cinema), CinemaResponseDto.class);
    }

    private Cinema findById(Integer id) {
        return cinemaRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }
}
