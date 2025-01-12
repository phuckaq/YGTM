package phuc.ygtm.pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // Update a session
    @PutMapping("/{id}")
    public ResponseEntity<PSessionDto> updateSession(@PathVariable String id, @RequestBody PSessionDto sessionDto) {
        sessionDto.setId(Long.valueOf(id));
        return ResponseEntity.ok(sessionService.updateSession(sessionDto));
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
