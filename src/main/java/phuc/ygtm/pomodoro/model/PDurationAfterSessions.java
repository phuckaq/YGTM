package phuc.ygtm.pomodoro.model;

import lombok.Getter;

@Getter
public enum PDurationAfterSessions {
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int value;

    PDurationAfterSessions(int value) {
        this.value = value;
    }

    public static PDurationAfterSessions fromValue(int value) {
        for (PDurationAfterSessions duration : PDurationAfterSessions.values()) {
            if (duration.getValue() == value) {
                return duration;
            }
        }
        throw new IllegalArgumentException("Invalid PDurationAfterSessions value: " + value);
    }
}
