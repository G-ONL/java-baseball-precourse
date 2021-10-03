package baseball.model;

public class Player {

    private GameNumbers gameNumbers;

    public Player(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public GameNumbers getGameNumbers() {
        return gameNumbers;
    }
}
