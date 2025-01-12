package phuc.ygtm.pomodoro.service;


import phuc.ygtm.pomodoro.dto.PSessionDto;

import java.util.List;

public interface PSessionService {
    PSessionDto getSession(String sessionId);
    PSessionDto createSession(PSessionDto dto);
    PSessionDto updateSession(PSessionDto dto);
    void deleteSession(String sessionId);
    List<PSessionDto> getAllSessions();
}
