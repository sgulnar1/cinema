package aze.coders.cinema.service;

import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.model.response.exception.ErrorMessageResponse;

public interface ErrorMessageService {
    ErrorMessageResponse getErrorMessageByCode(ErrorCode errorCode);
}
