package phuc.ygtm.pomodoro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phuc.ygtm.pomodoro.dto.PConfigDto;
import phuc.ygtm.pomodoro.mapper.PConfigMapper;
import phuc.ygtm.pomodoro.model.PConfig;
import phuc.ygtm.pomodoro.repo.PConfigRepo;
import phuc.ygtm.pomodoro.service.PConfigService;

@Service
@Transactional(rollbackFor = Throwable.class)
public class PConfigServiceImpl implements PConfigService {

    @Autowired
    private PConfigRepo pConfigRepo;

    @Override
    public PConfigDto getConfig() {
        return PConfigMapper.INSTANCE.toDTO(pConfigRepo.findAll().get(0));
    }

    @Override
    public PConfigDto updateConfig(PConfigDto dto) {
        PConfig pConfig = pConfigRepo.findById(dto.getId()).get();
        pConfig.setPDurationAfterSessions(dto.getPDurationAfterSessions());
        pConfig.setPDurationBreak(dto.getPDurationBreak());
        pConfig.setPDurationWork(dto.getPDurationWork());
        pConfig.setPNotificationType(dto.getPNotificationType());
        return PConfigMapper.INSTANCE.toDTO(pConfigRepo.save(pConfig));
    }
}
