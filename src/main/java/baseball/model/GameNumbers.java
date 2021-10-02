package baseball.model;

import baseball.view.Validator;

import java.util.HashSet;
import java.util.Set;

public class GameNumbers {

    private Set<GameNumber> numbers = new HashSet<>();

    public GameNumbers(String numbers) {
        for (char number : numbers.toCharArray()) {
            this.numbers.add(new GameNumber(number));
        }
    }

    private void isValid(String input) {
        if (!Validator.lengthCheck(numbers)) {
            throw new IllegalArgumentException("ERROR");
        }
    }
}
