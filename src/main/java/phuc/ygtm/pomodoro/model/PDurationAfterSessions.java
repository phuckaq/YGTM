package phuc.ygtm.pomodoro.model;

public enum PDurationAfterSessions {
    TWO, THREE, FOUR;

    public int toMinutes() {
        switch (this) {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            default:
                throw new IllegalArgumentException("Unknown duration: " + this);
        }
    }
}
