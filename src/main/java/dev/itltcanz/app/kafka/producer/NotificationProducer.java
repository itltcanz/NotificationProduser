package dev.itltcanz.app.kafka.producer;

import dev.itltcanz.app.model.message.NotificationMessage;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationProducer {

  private final KafkaTemplate<UUID, NotificationMessage> kafkaTemplate;

  @Value("${spring.kafka.topic}")
  private String topic;

  public CompletableFuture<SendResult<UUID, NotificationMessage>> send(UUID key, NotificationMessage message) {
    return kafkaTemplate.send(topic, key, message)
        .whenComplete((result, ex) -> {
              if (ex == null) {
                log.info("Сообщение отправлено в топик {}", topic);
              } else {
                log.error("Ошибка отправки сообщения в топик {}", topic, ex);
              }
            }
        );
  }

}
