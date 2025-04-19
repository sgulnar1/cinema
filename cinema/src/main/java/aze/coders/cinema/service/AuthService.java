package aze.coders.cinema.service;

import aze.coders.cinema.model.request.auth.SignInRequest;
import aze.coders.cinema.model.response.auth.SignInResponse;
import org.springframework.http.HttpHeaders;

public interface AuthService {
    SignInResponse signIn(SignInRequest signInRequest);

    void clearCookie(HttpHeaders headers);

    void setCookie(HttpHeaders headers, SignInResponse signInResponse);

    void signOut(String refreshToken);

    SignInResponse refreshToken(String refreshToken);
}
