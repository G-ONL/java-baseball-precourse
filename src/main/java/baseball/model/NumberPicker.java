package baseball.model;

public abstract class NumberPicker {

    private final GameNumbers gameNumbers;

    public NumberPicker(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public GameNumbers getGameNumbers() {
        return gameNumbers;
    }
}
