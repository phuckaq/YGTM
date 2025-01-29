package phuc.ygtm.pomodoro.model;

import lombok.Getter;

@Getter
public enum PDurationWork {
    TWENTY(20),
    TWENTY_FIVE(25),
    THIRTY(30);

    private final int value;

    PDurationWork(int value) {
        this.value = value;
    }

    public static PDurationWork fromValue(int value) {
        for (PDurationWork duration : PDurationWork.values()) {
            if (duration.getValue() == value) {
                return duration;
            }
        }
        throw new IllegalArgumentException("Invalid PDurationWork value: " + value);
    }
}
