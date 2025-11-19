package dev.itltcanz.app.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class ErrorMessageConstant {
  public static final String BAD_NOTIFICATION_TYPE = "Неправильный тип уведомления";
  public static final String BAD_REQUEST = "Неправильный запрос";
  public static final String INTERNAL_SERVER_ERROR = "Внутренняя ошибка сервера";
}
