package dev.itltcanz.app.model.enums;

import static dev.itltcanz.app.constant.ErrorMessageConstant.BAD_NOTIFICATION_TYPE;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum NotificationType {
  SMS("sms-events"),
  EMAIL("email-events"),
  PUSH("push-events"),
  TELEGRAM("telegram-events");

  private final String topic;

  @JsonCreator
  public static NotificationType fromString(String value) {
    return Arrays.stream(values())
        .filter(t -> t.name().equalsIgnoreCase(value) || t.topic.equalsIgnoreCase(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(BAD_NOTIFICATION_TYPE + " " + value));
  }

  @JsonValue
  public String getTopic() {
    return topic;
  }
}
