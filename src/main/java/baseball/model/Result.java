package baseball.model;

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
        if (isNotThing()) return "낫싱";
        if (strikeCount > 0) stringBuilder.append(strikeCount).append("스트라이크");
        if (strikeCount > 0 && ballCount > 0) stringBuilder.append(" ");
        if (ballCount > 0) stringBuilder.append(ballCount).append("볼");
        if (strikeCount == 3) stringBuilder.append("\n").append("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        return stringBuilder.toString();
    }

    private boolean isNotThing() {
        if (strikeCount == 0 && ballCount == 0) return true;
        return false;
    }
}
