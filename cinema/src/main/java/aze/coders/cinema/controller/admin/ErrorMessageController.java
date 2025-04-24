package aze.coders.cinema.controller.admin;

import aze.coders.cinema.dto.ErrorMessageDto;
import aze.coders.cinema.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/error-messages")
public class ErrorMessageController {
    private final ErrorMessageService errorMessageService;

    @GetMapping
    public ResponseEntity<List<ErrorMessageDto>> getErrorMessages() {
        return ResponseEntity.ok(errorMessageService.getErrorMessages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ErrorMessageDto> getErrorMessageById(@PathVariable Integer id) {
        return ResponseEntity.ok(errorMessageService.getErrorMessageById(id));
    }

    @PostMapping
    public ResponseEntity<ErrorMessageDto> createErrorMessage(@RequestBody ErrorMessageDto errorMessageDto) {
        return new ResponseEntity<>(errorMessageService.createErrorMessage(errorMessageDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteErrorMessage(@PathVariable Integer id) {
        errorMessageService.deleteErrorMessage(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorMessageDto> updateErrorMessage(@PathVariable Integer id, @RequestBody ErrorMessageDto errorMessageDto) {
        return ResponseEntity.ok(errorMessageService.updateErrorMessage(id, errorMessageDto));
    }
}