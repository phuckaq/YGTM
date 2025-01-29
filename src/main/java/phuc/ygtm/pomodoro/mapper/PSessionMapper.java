package phuc.ygtm.pomodoro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import phuc.ygtm.pomodoro.dto.PSessionDto;
import phuc.ygtm.pomodoro.model.PSession;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface PSessionMapper {

    PSessionDto toDTO(PSession session);

    PSession toEntity(PSessionDto sessionDTO);
}
