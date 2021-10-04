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
        int count = BaseBallConstants.ZERO_POINT;
        for (int i = 0; i < numbers.size(); i++) {
            count += countBallDifferentLocation(gameNumbers, i);
        }
        return count;
    }

    public int countStrike(GameNumbers gameNumbers) {
        int count = BaseBallConstants.ZERO_POINT;
        for (int i = 0; i < numbers.size(); i++) {
            count += getCountWhenSameIndexSameGameNumber(gameNumbers, i);
        }
        return count;
    }

    public GameNumber getGameNumber(int i) {
        return this.numbers.get(i);
    }

    private int countBallDifferentLocation(GameNumbers gameNumbers, int index) {
        int count = BaseBallConstants.ZERO_POINT;
        for (int comparisonIndex = 1; comparisonIndex < BaseBallConstants.GAME_RULE_LENGTH; comparisonIndex++) {
            count += getCountWhenDifferentLocationSameGameNumber(gameNumbers, index, comparisonIndex);
        }
        return count;
    }

    private int getCountWhenDifferentLocationSameGameNumber(GameNumbers gameNumbers, int index, int comparisonIndex) {
        GameNumber gameNumber = this.getGameNumber(index);
        if (gameNumber.equals(gameNumbers.getGameNumber((index + comparisonIndex) % BaseBallConstants.GAME_RULE_LENGTH))) {
            return BaseBallConstants.ONE_POINT;
        }
        return BaseBallConstants.ZERO_POINT;
    }

    private int getCountWhenSameIndexSameGameNumber(GameNumbers gameNumbers, int i) {
        if (this.getGameNumber(i).equals(gameNumbers.getGameNumber(i))) {
            return BaseBallConstants.ONE_POINT;
        }
        return BaseBallConstants.ZERO_POINT;
    }
}
