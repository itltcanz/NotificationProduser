package dev.itltcanz.app.handler;

import dev.itltcanz.app.model.event.NotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class NotificationEventHandler {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleNotificationPrepared(NotificationEvent event) {
        log.info("Сообщение для отправки подготовлено. key: {}, topic: {}, value: {},",
                event.getKey(), event.getTopic(), event.getValue());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleRollback(NotificationEvent event) {
        log.error("Сообщение для отправки не подготовлено. Транзакция откатилась. key: {}, topic: {}, value: {},",
                event.getKey(), event.getTopic(), event.getValue());
    }

}
