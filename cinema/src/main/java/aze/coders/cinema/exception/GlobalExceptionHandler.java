package aze.coders.cinema.exception;

import aze.coders.cinema.model.response.exception.ErrorMessageResponse;
import aze.coders.cinema.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ErrorMessageService errorMessageService;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handlerNotFoundException(NotFoundException ex) {
        return ResponseEntity.ok(errorMessageService.getErrorMessageByCode(ex.getErrorCode()));
    }
}
