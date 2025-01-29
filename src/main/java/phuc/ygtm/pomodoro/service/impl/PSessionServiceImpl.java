package phuc.ygtm.pomodoro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phuc.ygtm.pomodoro.dto.PSessionDto;
import phuc.ygtm.pomodoro.mapper.PConfigMapper;
import phuc.ygtm.pomodoro.mapper.PSessionMapper;
import phuc.ygtm.pomodoro.model.PSession;
import phuc.ygtm.pomodoro.repo.PSessionRepo;
import phuc.ygtm.pomodoro.service.PSessionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Throwable.class)
public class PSessionServiceImpl implements PSessionService {
    @Autowired
    private PSessionMapper pSessionMapper;

    @Autowired
    private PSessionRepo sessionRepository;


    @Override
    public PSessionDto getSession(String sessionId) {
        PSession session = sessionRepository.findById(Long.valueOf(sessionId))
                .orElseThrow(() -> new IllegalArgumentException("Session not found with id: " + sessionId));
        return pSessionMapper.toDTO(session);
    }

    @Override
    public PSessionDto createSession(PSessionDto dto) {
        PSession session = pSessionMapper.toEntity(dto);
        PSession savedSession = sessionRepository.save(session);
        return pSessionMapper.toDTO(savedSession);
    }

    @Override
    public void deleteSession(String sessionId) {
        sessionRepository.deleteById(Long.valueOf(sessionId));
    }

    @Override
    public List<PSessionDto> getAllSessions() {
        return sessionRepository.findAll().stream()
                .map(pSessionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
