package aze.coders.cinema.exception;

import aze.coders.cinema.enums.ErrorCode;
import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
