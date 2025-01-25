package phuc.ygtm.pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phuc.ygtm.pomodoro.dto.PSessionDto;
import phuc.ygtm.pomodoro.service.PSessionService;

import java.util.List;

@RestController
@RequestMapping("/p/session")
public class PSessionController {

    @Autowired
    private PSessionService sessionService;

    // Create a new session
    @PostMapping
    public ResponseEntity<PSessionDto> createSession(@RequestBody PSessionDto sessionDto) {
        return ResponseEntity.ok(sessionService.createSession(sessionDto));
    }

    // Get a session by ID
    @GetMapping("/{id}")
    public ResponseEntity<PSessionDto> getSession(@PathVariable String id) {
        return ResponseEntity.ok(sessionService.getSession(id));
    }


    // Delete a session
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable String id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    // Get all sessions
    @GetMapping
    public ResponseEntity<List<PSessionDto>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }
}
