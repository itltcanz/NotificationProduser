package dev.itltcanz.app.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateNotificationResponse {
  private String id;
  private String type;
  private String message;
}
