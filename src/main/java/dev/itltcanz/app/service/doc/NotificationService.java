package dev.itltcanz.app.service.doc;

import dev.itltcanz.app.model.entity.NotificationEntity;
import dev.itltcanz.app.model.request.CreateNotificationRequest;
import dev.itltcanz.app.model.response.CreateNotificationResponse;

@SuppressWarnings("UnusedReturnValue")
public interface NotificationService {

  /**
   * Сохраняет входящие уведомления
   *
   * @param request dto запроса на создание уведомления
   * @return dto ответа на создание уведомления
   */
  CreateNotificationResponse createNotification(CreateNotificationRequest request);

  Iterable<NotificationEntity> getAllBySentIsFalse();

  Iterable<NotificationEntity> saveAll(Iterable<NotificationEntity> notifications);

  NotificationEntity save(NotificationEntity notificationEntity);
}
