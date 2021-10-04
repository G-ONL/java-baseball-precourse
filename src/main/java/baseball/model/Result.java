package baseball.model;

import baseball.common.BaseBallConstants;
import baseball.common.ViewConstants;

public class Result {

    private int ballCount;
    private int strikeCount;

    public Result(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isMatchContinue() {
        if (strikeCount == BaseBallConstants.GAME_RULE_LENGTH) return false;
        return true;
    }

    public String gameResult() {
        if (isNotThing()) return ViewConstants.NOTING;
        StringBuilder stringBuilder = settingStringForResult();
        return stringBuilder.toString();
    }

    private StringBuilder settingStringForResult() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strikeCount > 0) stringBuilder.append(strikeCount).append(ViewConstants.STRIKE);
        if (strikeCount > 0 && ballCount > 0) stringBuilder.append(ViewConstants.SPACE);
        if (ballCount > 0) stringBuilder.append(ballCount).append(ViewConstants.BALL);
        if (strikeCount == BaseBallConstants.GAME_RULE_LENGTH) {
            stringBuilder.append(ViewConstants.NEW_LINE).append(ViewConstants.GAME_END);
        }
        return stringBuilder;
    }

    private boolean isNotThing() {
        if (strikeCount == 0 && ballCount == 0) return true;
        return false;
    }
}
