package dev.itltcanz.app.model.message;

import dev.itltcanz.app.model.enums.NotificationType;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationMessage {
  private NotificationType topic;
  private Map<String, Object> value;
}
