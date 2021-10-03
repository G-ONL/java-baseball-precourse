package baseball.model;

import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.Validator;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseBallGame {

    public static GameNumbers createGameNumbers() {
        Set<GameNumber> gameNumbers;
        do {
            gameNumbers = new LinkedHashSet<>();
            char[] numbers = InputView.inputGameNumber().toCharArray();
            for (char number : numbers) {
                gameNumbers.add(new GameNumber(Character.getNumericValue(number)));
            }
        } while (!Validator.isValidGameNumbers(gameNumbers));
        return new GameNumbers(gameNumbers);
    }

    public static Result match(Player player, Computer computer) {
        int ballCount = computer.getTargetNumbers().countBall(player.getGameNumbers());
        int strikeCount = computer.getTargetNumbers().countStrike(player.getGameNumbers());
        return new Result(ballCount, strikeCount);
    }

    public static void gameResult(Result result) {
        OutputView.output(result.gameResult());
    }
}
