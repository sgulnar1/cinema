package aze.coders.cinema.service.impl;

import aze.coders.cinema.config.EnhancedObjectMapper;
import aze.coders.cinema.dto.LanguageDto;
import aze.coders.cinema.entity.Language;
import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.exception.NotFoundException;
import aze.coders.cinema.repository.LanguageRepository;
import aze.coders.cinema.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final EnhancedObjectMapper mapper;

    @Override
    public List<LanguageDto> getLanguages() {
        return Arrays.asList(mapper.convertValue(languageRepository.findAll(), LanguageDto[].class));
    }

    @Override
    public LanguageDto getLanguageById(Integer id) {
        return mapper.convertValue(findById(id), LanguageDto.class);
    }

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {
        return mapper.convertValue(languageRepository.save(mapper.convertValue(languageDto, Language.class)), LanguageDto.class);
    }

    @Override
    public void deleteLanguage(Integer id) {
        findById(id);
        languageRepository.deleteById(id);
    }

    @Override
    public LanguageDto updateLanguage(Integer id, LanguageDto languageDto) {
        Language findLanguage = findById(id);
        Language language = mapper.convertValue(languageDto, Language.class);
        language.setId(findLanguage.getId());
        return mapper.convertValue(languageRepository.save(language), LanguageDto.class);
    }

    private Language findById(Integer id) {
        return languageRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }
}