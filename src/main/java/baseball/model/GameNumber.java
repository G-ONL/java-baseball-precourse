package baseball.model;

import baseball.view.OutputView;
import baseball.view.Validator;

public class GameNumber {

    private int number;

    public GameNumber(char input) {
        isValid(input);
        this.number = Character.getNumericValue(input);
    }

    private void isValid(char input) {
        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException("ERROR");
        }
        if (Validator.isZero(input)) {
            throw new IllegalArgumentException("ERROR");
        }
    }
}
