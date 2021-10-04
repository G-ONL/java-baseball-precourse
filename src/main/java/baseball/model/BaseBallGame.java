package baseball.model;

import baseball.common.BaseBallConstants;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.Validator;
import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseBallGame {

    public static GameNumbers createGameNumbers() {
        Set<GameNumber> gameNumbers;
        do {
            gameNumbers = new LinkedHashSet<>();
            settingGameNumbersByInputValue(gameNumbers);
        } while (!Validator.isValidGameNumbers(gameNumbers));
        return new GameNumbers(gameNumbers);
    }

    public static GameNumbers createRandomGameNumbers() {
        Set<GameNumber> numbers = new LinkedHashSet<>();
        while (numbers.size() != BaseBallConstants.GAME_RULE_LENGTH) {
            numbers.add(new GameNumber(Randoms.pickNumberInRange(1, 9)));
        }
        return new GameNumbers(numbers);
    }

    public static Result match(NumberPicker player, NumberPicker computer) {
        int ballCount = computer.getGameNumbers().countBall(player.getGameNumbers());
        int strikeCount = computer.getGameNumbers().countStrike(player.getGameNumbers());
        return new Result(ballCount, strikeCount);
    }

    private static void settingGameNumbersByInputValue(Set<GameNumber> gameNumbers) {
        char[] numbers = InputView.inputGameNumber().toCharArray();
        for (char number : numbers) {
            gameNumbers.add(new GameNumber(Character.getNumericValue(number)));
        }
    }

    public static void gameResult(Result result) {
        OutputView.output(result.gameResult());
    }
}
