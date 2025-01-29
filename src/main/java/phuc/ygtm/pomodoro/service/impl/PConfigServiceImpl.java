package phuc.ygtm.pomodoro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phuc.ygtm.pomodoro.dto.PConfigDto;
import phuc.ygtm.pomodoro.mapper.PConfigMapper;
import phuc.ygtm.pomodoro.model.PConfig;
import phuc.ygtm.pomodoro.model.PDurationAfterSessions;
import phuc.ygtm.pomodoro.model.PDurationBreak;
import phuc.ygtm.pomodoro.model.PDurationWork;
import phuc.ygtm.pomodoro.repo.PConfigRepo;
import phuc.ygtm.pomodoro.service.PConfigService;

@Service
@Transactional(rollbackFor = Throwable.class)
public class PConfigServiceImpl implements PConfigService {

    @Autowired
    private PConfigMapper pConfigMapper;

    @Autowired
    private PConfigRepo pConfigRepo;

    @Override
    public PConfigDto getConfig() {
        return pConfigMapper.toDTO(pConfigRepo.findAll().get(0));
    }

    @Override
    public PConfigDto updateConfig(PConfigDto dto) {
        PConfig pConfig = pConfigRepo.findById(dto.getId()).get();
        pConfig.setDurationAfterSessions(PDurationAfterSessions.fromValue(dto.getDurationAfterSessions()));
        pConfig.setDurationBreak(PDurationBreak.fromValue(dto.getDurationBreak()));
        pConfig.setDurationWork(PDurationWork.fromValue(dto.getDurationWork()));
        pConfig.setNotificationType(dto.getNotificationType());
        return pConfigMapper.toDTO(pConfigRepo.save(pConfig));
    }
}
