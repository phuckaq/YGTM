package phuc.ygtm.pomodoro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phuc.ygtm.pomodoro.dto.PSessionDto;
import phuc.ygtm.pomodoro.mapper.PSessionMapper;
import phuc.ygtm.pomodoro.model.PDuration;
import phuc.ygtm.pomodoro.model.PSession;
import phuc.ygtm.pomodoro.repo.PSessionRepo;
import phuc.ygtm.pomodoro.service.PSessionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Throwable.class)
public class PSessionServiceImpl implements PSessionService {

    @Autowired
    private PSessionRepo sessionRepository;


    @Override
    public PSessionDto getSession(String sessionId) {
        PSession session = sessionRepository.findById(Long.valueOf(sessionId))
                .orElseThrow(() -> new IllegalArgumentException("Session not found with id: " + sessionId));
        return PSessionMapper.INSTANCE.toDTO(session);
    }

    @Override
    public PSessionDto createSession(PSessionDto dto) {
        PSession session = PSessionMapper.INSTANCE.toEntity(dto);

        if (session.getPDuration() == null) {
            session.setPDuration(PDuration.TWENTY_FIVE);
        }

        session.setEndTime(session.getStartTime().plusMinutes(session.getPDuration().toMinutes()));
        PSession savedSession = sessionRepository.save(session);

        return PSessionMapper.INSTANCE.toDTO(savedSession);
    }

    @Override
    public PSessionDto updateSession(PSessionDto dto) {
        PSession existingSession = sessionRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Session not found with id: " + dto.getId()));

        existingSession.setStartTime(dto.getStartTime());
        existingSession.setPDuration(dto.getPDuration());
        existingSession.setEndTime(dto.getStartTime().plusMinutes(dto.getPDuration().toMinutes()));
        existingSession.setPStatus(dto.getPStatus());
        existingSession.setPType(dto.getPType());

        PSession updatedSession = sessionRepository.save(existingSession);
        return PSessionMapper.INSTANCE.toDTO(updatedSession);
    }

    @Override
    public void deleteSession(String sessionId) {
        sessionRepository.deleteById(Long.valueOf(sessionId));
    }

    @Override
    public List<PSessionDto> getAllSessions() {
        return sessionRepository.findAll().stream()
                .map(PSessionMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
