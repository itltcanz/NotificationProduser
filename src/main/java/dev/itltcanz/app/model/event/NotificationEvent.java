package dev.itltcanz.app.model.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationEvent {
    private String key;
    private String topic;
    private String value;
}
