package aze.coders.cinema.controller.auth;

import aze.coders.cinema.config.JwtFilter;
import aze.coders.cinema.model.request.auth.SignInRequest;
import aze.coders.cinema.model.response.auth.SignInResponse;
import aze.coders.cinema.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> token(@RequestBody SignInRequest signInRequest) {
        SignInResponse signInResponse = authService.signIn(signInRequest);
        HttpHeaders headers = new HttpHeaders();
        authService.setCookie(headers, signInResponse);
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/sign-out")
    public ResponseEntity<?> signOut(@CookieValue(name = JwtFilter.REFRESH_TOKEN) String refreshToken) {
        authService.signOut(refreshToken);
        HttpHeaders headers = new HttpHeaders();
        authService.clearCookie(headers);
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@CookieValue(name = "refresh-token") String refreshToken) {
        SignInResponse signInResponse = authService.refreshToken(refreshToken);
        HttpHeaders headers = new HttpHeaders();
        authService.setCookie(headers, signInResponse);
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);

    }
}
