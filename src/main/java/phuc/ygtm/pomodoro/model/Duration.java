package phuc.ygtm.pomodoro.model;

public enum Duration {
    TWENTY,TWENTY_FIVE,THIRTY;

    public int toMinutes() {
        switch (this) {
            case TWENTY:
                return 20;
            case TWENTY_FIVE:
                return 25;
            case THIRTY:
                return 30;
            default:
                throw new IllegalArgumentException("Unknown duration: " + this);
        }
    }
}
