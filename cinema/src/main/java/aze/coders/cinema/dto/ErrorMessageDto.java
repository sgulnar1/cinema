package aze.coders.cinema.dto;

import aze.coders.cinema.enums.ErrorCode;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ErrorMessageDto {
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ErrorCode errorCode;
    private List<ErrorMessageTranslationDto> translations;
}
