package dev.itltcanz.app.controller.impl;

import dev.itltcanz.app.controller.doc.NotificationController;
import dev.itltcanz.app.model.request.CreateNotificationRequest;
import dev.itltcanz.app.model.response.CreateNotificationResponse;
import dev.itltcanz.app.service.impl.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class NotificationControllerImpl implements NotificationController {

  private final NotificationService notificationService;

  @Override
  public ResponseEntity<CreateNotificationResponse> createNotification(CreateNotificationRequest request) {
    CreateNotificationResponse response = notificationService.createNotification(request);
    return ResponseEntity.ok(response);
  }
}
