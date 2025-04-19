package aze.coders.cinema.service.impl;

import aze.coders.cinema.entity.ErrorMessage;
import aze.coders.cinema.entity.ErrorMessageTranslation;
import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.model.response.exception.ErrorMessageResponse;
import aze.coders.cinema.repository.ErrorMessageRepository;
import aze.coders.cinema.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static aze.coders.cinema.interceptor.HeaderInterceptor.LANGUAGE;

@Service
@RequiredArgsConstructor
public class ErrorMessageServiceImpl implements ErrorMessageService {

    private final ErrorMessageRepository errorMessageRepository;

    @Override
    public ErrorMessageResponse getErrorMessageByCode(ErrorCode errorCode) {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(errorCode);
        Optional<ErrorMessage> errorMessage = errorMessageRepository.findByErrorCode(errorCode);
        if (errorMessage.isPresent()) {
            Optional<ErrorMessageTranslation> translation = errorMessage.get().getTranslations().stream().filter(t -> t.getLanguage().getLanguage().equals(LANGUAGE)).findFirst();
            translation.ifPresent(errorMessageTranslation -> errorMessageResponse.setMessage(errorMessageTranslation.getMessage()));
        }
        return errorMessageResponse;
    }
}
