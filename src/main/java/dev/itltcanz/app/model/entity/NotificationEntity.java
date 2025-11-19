package dev.itltcanz.app.model.entity;

import dev.itltcanz.app.model.enums.NotificationType;
import dev.itltcanz.app.util.NotificationTypeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("unused")
@Entity(name = "notification_outbox")
public class NotificationEntity {

  @Id
  @Column(name = "id")
  @Setter(AccessLevel.NONE)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Convert(converter = NotificationTypeConverter.class)
  @Column(name = "topic", nullable = false)
  private NotificationType topic;

  @Setter(AccessLevel.NONE)
  @Column(name = "key", nullable = false)
  private UUID key = UUID.randomUUID();

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(name = "value", nullable = false, columnDefinition = "jsonb")
  private Map<String, Object> value;

  @Column(name = "sent", nullable = false)
  private Boolean sent = false;

  @Column(name = "attempt", nullable = false)
  private Integer attempt = 0;

  @Setter(AccessLevel.NONE)
  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt = Instant.now();

  // Геттеры для маппинга
  public String getIdAsString() {
    return id.toString();
  }

  public String getKeyAsString() {
    return key.toString();
  }

  public String getTypeAsText() {
    return topic.name();
  }

  public String getTopicAsText() {
    return topic.getTopic();
  }

  public void incrementAttempt() {
    attempt += 1;
  }
}