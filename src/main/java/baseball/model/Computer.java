package baseball.model;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

    private final GameNumbers goalNumbers;

    public Computer() {
        Set<GameNumber> numbers = new LinkedHashSet<>();
        while (numbers.size() != 3) {
            numbers.add(new GameNumber(Randoms.pickNumberInRange(1, 9)));
        }
        goalNumbers = new GameNumbers(numbers);
    }

    public GameNumbers getGoalNumbers() {
        return this.goalNumbers;
    }
}
