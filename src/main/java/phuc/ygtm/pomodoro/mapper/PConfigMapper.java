package phuc.ygtm.pomodoro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import phuc.ygtm.pomodoro.dto.PConfigDto;
import phuc.ygtm.pomodoro.model.PConfig;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PConfigMapper {
    PConfigMapper INSTANCE = Mappers.getMapper(PConfigMapper.class);

    PConfigDto toDTO(PConfig pConfig);

    PConfig toEntity(PConfigDto pConfigDto);
}
