package dev.itltcanz.app.service.impl;

import dev.itltcanz.app.entity.NotificationEntity;
import dev.itltcanz.app.mapper.NotificationMapper;
import dev.itltcanz.app.model.request.CreateNotificationRequest;
import dev.itltcanz.app.model.response.CreateNotificationResponse;
import dev.itltcanz.app.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

  private final NotificationRepository notificationRepository;
  private final NotificationMapper notificationMapper;

  public CreateNotificationResponse createNotification(CreateNotificationRequest request) {
    NotificationEntity entity = notificationMapper.toEntity(request);
    entity = notificationRepository.save(entity);
    return notificationMapper.toResponse(entity);
  }

}
