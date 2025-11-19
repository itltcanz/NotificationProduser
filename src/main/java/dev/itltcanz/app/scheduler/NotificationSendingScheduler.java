package dev.itltcanz.app.scheduler;

import dev.itltcanz.app.service.impl.NotificationSendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationSendingScheduler {

  private final NotificationSendingService messageSendingService;

  @Scheduled(fixedDelayString = "${outbox.delay-ms}")
  private void sendMessage() {
    messageSendingService.sendPreparedMessages();
  }

}
