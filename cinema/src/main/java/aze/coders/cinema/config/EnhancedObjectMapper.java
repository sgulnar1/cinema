package aze.coders.cinema.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnhancedObjectMapper {
    private final ObjectMapper objectMapper;

    public EnhancedObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <D, E> E convertValue(D source, Class<E> targetType) {
        E result = objectMapper.convertValue(source, targetType);
        GenericRelationBinder.bind(result);
        return result;
    }

    public <E, D> List<D> convertList(List<E> source, Class<D> targetType) {
        return objectMapper.convertValue(
                source,
                objectMapper.getTypeFactory().constructCollectionType(List.class, targetType)
        );
    }
}
