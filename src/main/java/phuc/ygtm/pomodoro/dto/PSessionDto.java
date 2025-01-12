package phuc.ygtm.pomodoro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import phuc.ygtm.pomodoro.model.Duration;
import phuc.ygtm.pomodoro.model.Status;
import phuc.ygtm.pomodoro.model.Type;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PSessionDto {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Type type;
    private Status status;
    private Duration duration;
}
