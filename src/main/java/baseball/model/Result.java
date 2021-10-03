package baseball.model;

import baseball.common.ViewConstants;

public class Result {
    private int ballCount;
    private int strikeCount;

    public Result(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isMatchContinue() {
        if (strikeCount == 3) return false;
        return true;
    }

    public String gameResult() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isNotThing()) return ViewConstants.NOTING;
        if (strikeCount > 0) stringBuilder.append(strikeCount).append(ViewConstants.STRIKE);
        if (strikeCount > 0 && ballCount > 0) stringBuilder.append(" ");
        if (ballCount > 0) stringBuilder.append(ballCount).append(ViewConstants.BALL);
        if (strikeCount == 3) stringBuilder.append("\n").append(ViewConstants.GAME_END);
        return stringBuilder.toString();
    }

    private boolean isNotThing() {
        if (strikeCount == 0 && ballCount == 0) return true;
        return false;
    }
}
