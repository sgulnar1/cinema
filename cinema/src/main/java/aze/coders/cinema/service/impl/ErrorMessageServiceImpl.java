package aze.coders.cinema.service.impl;

import aze.coders.cinema.config.EnhancedObjectMapper;
import aze.coders.cinema.dto.ErrorMessageDto;
import aze.coders.cinema.entity.ErrorMessage;
import aze.coders.cinema.entity.ErrorMessageTranslation;
import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.exception.NotFoundException;
import aze.coders.cinema.model.response.exception.ErrorMessageResponse;
import aze.coders.cinema.repository.ErrorMessageRepository;
import aze.coders.cinema.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static aze.coders.cinema.interceptor.HeaderInterceptor.LANGUAGE;

@Service
@RequiredArgsConstructor
public class ErrorMessageServiceImpl implements ErrorMessageService {

    private final ErrorMessageRepository errorMessageRepository;
    private final EnhancedObjectMapper mapper;

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

    @Override
    public List<ErrorMessageDto> getErrorMessages() {
        return Arrays.asList(mapper.convertValue(errorMessageRepository.findAll(), ErrorMessageDto[].class));
    }

    @Override
    public ErrorMessageDto getErrorMessageById(Integer id) {
        return mapper.convertValue(findById(id), ErrorMessageDto.class);
    }

    @Override
    public ErrorMessageDto createErrorMessage(ErrorMessageDto errorMessageDto) {
        //ErrorMessage save = errorMessageRepository.save(mapper.convertValue(errorMessageDto, ErrorMessage.class));
        //save.getTranslations().forEach(translation -> translation.setErrorMessage(save));
        return mapper.convertValue(errorMessageRepository.save(mapper.convertValue(errorMessageDto, ErrorMessage.class)), ErrorMessageDto.class);
    }

    @Override
    public void deleteErrorMessage(Integer id) {
        findById(id);
        errorMessageRepository.deleteById(id);
    }

    @Override
    public ErrorMessageDto updateErrorMessage(Integer id, ErrorMessageDto errorMessageDto) {
        ErrorMessage findErrorMessage = findById(id);
        ErrorMessage errorMessage = mapper.convertValue(errorMessageDto, ErrorMessage.class);
        errorMessage.setId(findErrorMessage.getId());
        return mapper.convertValue(errorMessageRepository.save(errorMessage), ErrorMessageDto.class);
    }

    private ErrorMessage findById(Integer id) {
        return errorMessageRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }
}