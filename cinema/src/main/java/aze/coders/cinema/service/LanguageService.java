package aze.coders.cinema.service;

import aze.coders.cinema.dto.LanguageDto;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> getLanguages();
    LanguageDto getLanguageById(Integer id);
    LanguageDto createLanguage(LanguageDto languageDto);
    void deleteLanguage(Integer id);
    LanguageDto updateLanguage(Integer id, LanguageDto languageDto);
}
