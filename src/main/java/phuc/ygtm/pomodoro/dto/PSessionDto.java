package phuc.ygtm.pomodoro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phuc.ygtm.pomodoro.model.PDurationBreak;
import phuc.ygtm.pomodoro.model.PDurationWork;
import phuc.ygtm.pomodoro.model.PStatus;
import phuc.ygtm.pomodoro.model.PType;

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
    private PType PType;
    private PStatus PStatus;
    private PDurationWork PDurationWork;
    private PDurationBreak pDurationBreak;
}
