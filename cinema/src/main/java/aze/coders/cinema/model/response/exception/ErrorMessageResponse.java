package aze.coders.cinema.model.response.exception;

import aze.coders.cinema.enums.ErrorCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessageResponse {
    private ErrorCode errorCode;
    private String message;

    public ErrorMessageResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
