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

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "p_config")
public class PConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration_work", nullable = false)
    private PDurationWork durationWork;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration_break", nullable = false)
    private PDurationBreak durationBreak;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration_after_sessions", nullable = false)
    private PDurationAfterSessions durationAfterSessions;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", nullable = false)
    private PNotificationType notificationType;
}
