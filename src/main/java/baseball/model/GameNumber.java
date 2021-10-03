package baseball.model;

public class GameNumber {

    private int number;

    public GameNumber(int input) {
        this.number = Character.getNumericValue(input);
    }
}
