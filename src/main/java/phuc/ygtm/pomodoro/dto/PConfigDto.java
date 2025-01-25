package phuc.ygtm.pomodoro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phuc.ygtm.pomodoro.model.PDurationAfterSessions;
import phuc.ygtm.pomodoro.model.PDurationBreak;
import phuc.ygtm.pomodoro.model.PDurationWork;
import phuc.ygtm.pomodoro.model.PNotificationType;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class PConfigDto {

    private Long id;
    private PDurationWork pDurationWork;
    private PDurationBreak pDurationBreak;
    private PDurationAfterSessions pDurationAfterSessions;
    private PNotificationType pNotificationType;
}
