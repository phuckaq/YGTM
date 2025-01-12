package phuc.ygtm.pomodoro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phuc.ygtm.pomodoro.model.NotificationType;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class PConfigDto {

    private Long id;
    private int workSessionLength;
    private int breakSessionLength;
    private int sessionsBeforeLongBreak;
    private NotificationType notification;
}
