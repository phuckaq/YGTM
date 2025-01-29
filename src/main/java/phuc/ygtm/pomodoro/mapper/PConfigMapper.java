package phuc.ygtm.pomodoro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import phuc.ygtm.pomodoro.dto.PConfigDto;
import phuc.ygtm.pomodoro.model.PConfig;
import phuc.ygtm.pomodoro.model.PDurationWork;
import phuc.ygtm.pomodoro.model.PDurationBreak;
import phuc.ygtm.pomodoro.model.PDurationAfterSessions;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface PConfigMapper {

    PConfigMapper INSTANCE = Mappers.getMapper(PConfigMapper.class);

    // **Mapping Enum to Integer (DTO conversion)**
    @Mapping(target = "durationWork", source = "durationWork", qualifiedByName = "mapWorkToInteger")
    @Mapping(target = "durationBreak", source = "durationBreak", qualifiedByName = "mapBreakToInteger")
    @Mapping(target = "durationAfterSessions", source = "durationAfterSessions", qualifiedByName = "mapAfterSessionsToInteger")
    PConfigDto toDTO(PConfig pConfig);

    // **Mapping Integer to Enum (Entity conversion)**
    @Mapping(target = "durationWork", source = "durationWork", qualifiedByName = "mapIntegerToWork")
    @Mapping(target = "durationBreak", source = "durationBreak", qualifiedByName = "mapIntegerToBreak")
    @Mapping(target = "durationAfterSessions", source = "durationAfterSessions", qualifiedByName = "mapIntegerToAfterSessions")
    PConfig toEntity(PConfigDto pConfigDto);

    // **Enum to Integer Mapping**
    @Named("mapWorkToInteger")
    default Integer mapWorkToInteger(PDurationWork duration) {
        return duration != null ? duration.getValue() : null;
    }

    @Named("mapBreakToInteger")
    default Integer mapBreakToInteger(PDurationBreak duration) {
        return duration != null ? duration.getValue() : null;
    }

    @Named("mapAfterSessionsToInteger")
    default Integer mapAfterSessionsToInteger(PDurationAfterSessions duration) {
        return duration != null ? duration.getValue() : null;
    }

    // **Integer to Enum Mapping**
    @Named("mapIntegerToWork")
    default PDurationWork mapIntegerToWork(Integer value) {
        return value != null ? PDurationWork.fromValue(value) : null;
    }

    @Named("mapIntegerToBreak")
    default PDurationBreak mapIntegerToBreak(Integer value) {
        return value != null ? PDurationBreak.fromValue(value) : null;
    }

    @Named("mapIntegerToAfterSessions")
    default PDurationAfterSessions mapIntegerToAfterSessions(Integer value) {
        return value != null ? PDurationAfterSessions.fromValue(value) : null;
    }
}