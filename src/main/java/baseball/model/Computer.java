package baseball.model;

import baseball.common.BaseBallConstants;
import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer{
    private final GameNumbers targetNumbers;

    public Computer() {
        Set<GameNumber> numbers = new LinkedHashSet<>();
        while (numbers.size() != BaseBallConstants.GAME_RULE_LENGTH) {
            numbers.add(new GameNumber(Randoms.pickNumberInRange(1, 9)));
        }
        this.targetNumbers = new GameNumbers(numbers);
    }

    public GameNumbers getTargetNumbers() {
        return this.targetNumbers;
    }
}
