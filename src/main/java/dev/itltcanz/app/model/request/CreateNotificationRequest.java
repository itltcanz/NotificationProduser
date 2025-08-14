package dev.itltcanz.app.model.request;

import dev.itltcanz.app.model.enums.NotificationEnum;
public record CreateNotificationRequest(NotificationEnum type, String message){}
