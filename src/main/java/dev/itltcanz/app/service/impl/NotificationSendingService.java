package dev.itltcanz.app.service.impl;

import dev.itltcanz.app.kafka.producer.NotificationProducer;
import dev.itltcanz.app.mapper.NotificationMapper;
import dev.itltcanz.app.model.message.NotificationMessage;
import dev.itltcanz.app.service.doc.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NotificationSendingService {

  private final NotificationProducer producer;
  private final NotificationMapper notificationMapper;
  private final NotificationService notificationService;

  @Transactional
  public void sendPreparedMessages() {
    var notifications = notificationService.getAllBySentIsFalse();

    for (var notification : notifications) {
      NotificationMessage message = notificationMapper.toMessage(notification);
      producer.send(notification.getKey(), message)
          .thenAccept(result -> {
            notification.incrementAttempt();
            notification.setSent(true);
            notificationService.save(notification);
          })
          .exceptionally(ex -> {
            notification.incrementAttempt();
            notificationService.save(notification);
            return null;
          });
    }
    notificationService.saveAll(notifications);
  }
}
