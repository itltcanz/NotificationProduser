package dev.itltcanz.app.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.itltcanz.app.exception.ParsingException;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class MapParser {

  private final ObjectMapper objectMapper;

  @Named("stringToMap")
  public Map<String, Object> stringToMap(String message) {
    try {
      ObjectNode node = objectMapper.createObjectNode();
      node.put("value", message);
      return objectMapper.convertValue(node, new TypeReference<>() {});
    } catch (Exception e) {
      throw new ParsingException("Ошибка парсинга сообщения", e);
    }
  }

  @Named("mapToString")
  public String mapToString(Map<String, Object> message) {
    try {
      return objectMapper.writeValueAsString(message);
    } catch (Exception e) {
      throw new ParsingException("Ошибка парсинга сообщения", e);
    }
  }
}