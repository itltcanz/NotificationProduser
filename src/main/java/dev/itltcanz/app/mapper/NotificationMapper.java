package dev.itltcanz.app.mapper;

import dev.itltcanz.app.model.entity.NotificationEntity;
import dev.itltcanz.app.model.event.NotificationEvent;
import dev.itltcanz.app.model.message.NotificationMessage;
import dev.itltcanz.app.model.request.CreateNotificationRequest;
import dev.itltcanz.app.model.response.CreateNotificationResponse;
import dev.itltcanz.app.util.MapParser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = MapParser.class
)
public interface NotificationMapper {

  @Mapping(target = "value", source = "request.message", qualifiedByName = "stringToMap")
  @Mapping(target = "topic", source = "request.type")
  NotificationEntity toEntity(CreateNotificationRequest request);

  @Mapping(target = "id", source = "idAsString")
  @Mapping(target = "type", source = "typeAsText")
  @Mapping(target = "message", source = "value", qualifiedByName = "mapToString")
  CreateNotificationResponse toResponse(NotificationEntity entity);

  @Mapping(target = "key", source = "keyAsString")
  @Mapping(target = "topic", source = "topicAsText")
  @Mapping(target = "value", source = "value", qualifiedByName = "mapToString")
  NotificationEvent toEvent(NotificationEntity entity);

  NotificationMessage toMessage(NotificationEntity entity);
}
