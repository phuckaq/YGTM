package phuc.ygtm.pomodoro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phuc.ygtm.pomodoro.model.Duration;
import phuc.ygtm.pomodoro.model.Status;
import phuc.ygtm.pomodoro.model.Type;

import java.time.LocalDateTime;

@Getter
@Setter
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
