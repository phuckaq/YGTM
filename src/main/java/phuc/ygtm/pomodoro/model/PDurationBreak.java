package phuc.ygtm.pomodoro.model;

public enum PDurationBreak {
    FIVE, TEN;

    public int toMinutes() {
        switch (this) {
            case FIVE:
                return 5;
            case TEN:
                return 10;
            default:
                throw new IllegalArgumentException("Unknown duration: " + this);
        }
    }
}
