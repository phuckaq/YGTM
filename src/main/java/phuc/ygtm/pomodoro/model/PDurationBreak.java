package phuc.ygtm.pomodoro.model;

import lombok.Getter;

@Getter
public enum PDurationBreak {
    FIVE(5),
    TEN(10);

    private final int value;

    PDurationBreak(int value) {
        this.value = value;
    }
    public static PDurationBreak fromValue(int value) {
        for (PDurationBreak duration : PDurationBreak.values()) {
            if (duration.getValue() == value) {
                return duration;
            }
        }
        throw new IllegalArgumentException("Invalid PDurationBreak value: " + value);
    }
}
