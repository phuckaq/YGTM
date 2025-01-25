package phuc.ygtm.pomodoro.service;

import phuc.ygtm.pomodoro.dto.PConfigDto;

public interface PConfigService {
    PConfigDto getConfig();

    PConfigDto updateConfig(PConfigDto dto);
}
