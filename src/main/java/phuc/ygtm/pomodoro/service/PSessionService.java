package phuc.ygtm.pomodoro.service;


import phuc.ygtm.pomodoro.dto.PSessionDto;

import java.util.List;

public interface PSessionService {
    PSessionDto getSession(String sessionId);

    PSessionDto createSession(PSessionDto dto);

    void deleteSession(String sessionId);

    List<PSessionDto> getAllSessions();
}
