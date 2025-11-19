package dev.itltcanz.app.controller.doc;

import static dev.itltcanz.app.constant.ApiConstant.NOTIFICATION_URL;

import dev.itltcanz.app.model.request.CreateNotificationRequest;
import dev.itltcanz.app.model.response.CreateNotificationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(NOTIFICATION_URL)
@Tag(name = "Notification controller", description = "Контроллер для управления уведомлениями")
public interface NotificationController {
  @PostMapping
  @Operation(
      summary = "Создание уведомления",
      description = "Метод позволяет пользователю создавать новое уведомление",
      responses = {
              @ApiResponse(responseCode = "201", description = "Уведомление успешно создано"),
              @ApiResponse(responseCode = "400", description = "Неправильные параметры запроса"),
              @ApiResponse(responseCode = "401", description = "Пользователь не аутентифицирован"),
              @ApiResponse(responseCode = "403", description = "Недостаточно прав пользователя"),
              @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
      }
  )
  ResponseEntity<CreateNotificationResponse> createNotification(@RequestBody @Valid CreateNotificationRequest request);
}
