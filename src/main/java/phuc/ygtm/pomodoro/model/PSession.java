package phuc.ygtm.pomodoro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "p_session")
public class PSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration_work")
    private PDurationWork durationWork;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration_break")
    private PDurationBreak durationBreak;
}
