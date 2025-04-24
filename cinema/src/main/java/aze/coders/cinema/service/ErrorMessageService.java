package aze.coders.cinema.service;

import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.model.response.exception.ErrorMessageResponse;
import aze.coders.cinema.dto.ErrorMessageDto;

import java.util.List;
public interface ErrorMessageService {
    ErrorMessageResponse getErrorMessageByCode(ErrorCode errorCode);
    List<ErrorMessageDto> getErrorMessages();
    ErrorMessageDto getErrorMessageById(Integer id);
    ErrorMessageDto createErrorMessage(ErrorMessageDto errorMessageDto);
    void deleteErrorMessage(Integer id);
    ErrorMessageDto updateErrorMessage(Integer id, ErrorMessageDto errorMessageDto);
}
