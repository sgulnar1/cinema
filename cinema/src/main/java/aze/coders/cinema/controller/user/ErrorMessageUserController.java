package aze.coders.cinema.controller.user;

import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.model.response.exception.ErrorMessageResponse;
import aze.coders.cinema.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/error-messages")
public class ErrorMessageUserController {
    private final ErrorMessageService errorMessageService;

    @GetMapping("/by-error-code")
    public ResponseEntity<ErrorMessageResponse> getErrorMessageByCode(@RequestParam("errorCode") ErrorCode errorCode) {
        return ResponseEntity.ok(errorMessageService.getErrorMessageByCode(errorCode));
    }

}
