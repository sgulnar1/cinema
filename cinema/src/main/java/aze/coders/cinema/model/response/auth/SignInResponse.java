package aze.coders.cinema.model.response.auth;

import aze.coders.cinema.dto.RefreshTokenDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponse {
    private AccessTokenResponse accessToken;
    private RefreshTokenDto refreshToken;
}
