package dev.itltcanz.app.service.impl;

import dev.itltcanz.app.mapper.NotificationMapper;
import dev.itltcanz.app.model.entity.NotificationEntity;
import dev.itltcanz.app.model.event.NotificationEvent;
import dev.itltcanz.app.model.request.CreateNotificationRequest;
import dev.itltcanz.app.model.response.CreateNotificationResponse;
import dev.itltcanz.app.repository.NotificationRepository;
import dev.itltcanz.app.service.doc.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

  private final Pageable batchPageable;
  private final NotificationMapper notificationMapper;
  private final ApplicationEventPublisher eventPublisher;
  private final NotificationRepository notificationRepository;

  @Override
  @Transactional
  public CreateNotificationResponse createNotification(CreateNotificationRequest request) {
    NotificationEntity entity = notificationMapper.toEntity(request);
    entity = notificationRepository.save(entity);
    NotificationEvent event = notificationMapper.toEvent(entity);
    eventPublisher.publishEvent(event);
    return notificationMapper.toResponse(entity);
  }

  @Override
  public Iterable<NotificationEntity> getAllBySentIsFalse() {
    return notificationRepository.findAllBySentIsFalse(batchPageable);
  }

  @Override
  public Iterable<NotificationEntity> saveAll(Iterable<NotificationEntity> notifications) {
    return notificationRepository.saveAll(notifications);
  }

  @Override
  public NotificationEntity save(NotificationEntity notificationEntity) {
    return notificationRepository.save(notificationEntity);
  }
}
