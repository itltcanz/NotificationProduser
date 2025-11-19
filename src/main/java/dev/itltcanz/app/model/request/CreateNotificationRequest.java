package dev.itltcanz.app.model.request;

import dev.itltcanz.app.model.enums.NotificationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateNotificationRequest {

    @Schema(description = "Тип уведомления", example = "SMS|EMAIL|PUSH|TG_MESSAGE")
    @NotNull(message = "Поле type не может быть пустым")
    NotificationType type;

    @Schema(description = "Текст уведомления", example = "Может содержать любой текст :)")
    @NotBlank(message = "Поле message не может быть пустым")
    String message;
}
