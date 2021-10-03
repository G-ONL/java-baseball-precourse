package baseball.model;

import baseball.view.InputView;
import baseball.view.Validator;

import java.util.HashSet;
import java.util.Set;

public class BaseBallGame {

    public static GameNumbers createGameNumbers() {
        Set<GameNumber> gameNumbers;
        do {
            gameNumbers = new HashSet<>();
            char[] numbers = InputView.inputGameNumber().toCharArray();
            for (char number : numbers) {
                gameNumbers.add(new GameNumber(number));
            }
        } while (!Validator.isValidGameNumbers(gameNumbers));
        return new GameNumbers(gameNumbers);
    }
}
