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

    @Column(name = "work_session_length", nullable = false)
    private int workSessionLength;

    @Column(name = "break_session_length", nullable = false)
    private int breakSessionLength;

    @Column(name = "sessions_before_long_break", nullable = false)
    private int sessionsBeforeLongBreak;

    @Enumerated(EnumType.STRING) // Store enum values as strings in the database
    @Column(name = "p_notification", nullable = false)
    private PNotificationType pNotification;
}
