package aze.coders.cinema.service.impl;

import aze.coders.cinema.config.EnhancedObjectMapper;
import aze.coders.cinema.dto.CinemaDto;
import aze.coders.cinema.entity.Cinema;
import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.exception.NotFoundException;
import aze.coders.cinema.repository.CinemaRepository;
import aze.coders.cinema.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final EnhancedObjectMapper mapper;

    @Override
    public List<CinemaDto> getCinemas() {
        return Arrays.asList(mapper.convertValue(cinemaRepository.findAll(), CinemaDto[].class));
    }

    @Override
    public CinemaDto getCinemaById(Integer id) {
        return mapper.convertValue(findById(id), CinemaDto.class);
    }

    @Override
    public CinemaDto createCinema(CinemaDto cinemaDto) {
        return mapper.convertValue(cinemaRepository.save(mapper.convertValue(cinemaDto, Cinema.class)), CinemaDto.class);
    }

    @Override
    public void deleteCinema(Integer id) {
        findById(id);
        cinemaRepository.deleteById(id);
    }

    @Override
    public CinemaDto updateCinema(Integer id, CinemaDto cinemaDto) {
        Cinema findCinema = findById(id);
        Cinema cinema = mapper.convertValue(cinemaDto, Cinema.class);
        cinema.setId(findCinema.getId());
        return mapper.convertValue(cinemaRepository.save(cinema), CinemaDto.class);
    }

    private Cinema findById(Integer id) {
        return cinemaRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }
}
