package dev.itltcanz.app.mapper;

import dev.itltcanz.app.entity.NotificationEntity;
import dev.itltcanz.app.model.request.CreateNotificationRequest;
import dev.itltcanz.app.model.response.CreateNotificationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class NotificationMapper {
  public abstract NotificationEntity toEntity(CreateNotificationRequest request);
  @Mapping(target = "id", source = "entity.id.toString()")
  @Mapping(target = "type", source = "entity.type.toString()")
  public abstract CreateNotificationResponse toResponse(NotificationEntity entity);
}
