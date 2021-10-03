package baseball.model;

import baseball.common.BaseBallConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameNumbers {

    private List<GameNumber> numbers = new ArrayList<>();

    public GameNumbers(Set<GameNumber> numbers) {
        this.numbers = new ArrayList(numbers);
    }

    public int countBall(GameNumbers gameNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            GameNumber gameNumber = this.getGameNumber(i);
            if (gameNumber.equals(gameNumbers.getGameNumber((i + 1) % BaseBallConstants.GAME_RULE_LENGTH))) {
                count++;
            }
            if (gameNumber.equals(gameNumbers.getGameNumber((i + 2) % BaseBallConstants.GAME_RULE_LENGTH))) {
                count++;
            }
        }
        return count;
    }

    public int countStrike(GameNumbers gameNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (this.getGameNumber(i).equals(gameNumbers.getGameNumber((i)))) {
                count++;
            }
        }
        return count;
    }

    public GameNumber getGameNumber(int i) {
        return this.numbers.get(i);
    }
}
