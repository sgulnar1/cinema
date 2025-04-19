package aze.coders.cinema.controller.admin;

import aze.coders.cinema.dto.CinemaRequestDto;
import aze.coders.cinema.dto.CinemaResponseDto;
import aze.coders.cinema.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    @GetMapping
    public ResponseEntity<List<CinemaResponseDto>> getCinemas() {
        return ResponseEntity.ok(cinemaService.getCinemas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaResponseDto> getCinemaById(@PathVariable Integer id) {
        return ResponseEntity.ok(cinemaService.getCinemaById(id));
    }

    @PostMapping
    public ResponseEntity<CinemaResponseDto> createCinema(@RequestBody CinemaRequestDto cinemaRequestDto) {
        return new ResponseEntity<>(cinemaService.createCinema(cinemaRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCinema(@PathVariable Integer id) {
        cinemaService.deleteCinema(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CinemaResponseDto> updateCinema(@PathVariable Integer id, @RequestBody CinemaRequestDto cinemaRequestDto) {
        return ResponseEntity.ok(cinemaService.updateCinema(id, cinemaRequestDto));
    }
}
