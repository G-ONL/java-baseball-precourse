package baseball.model;

public class GameMather {

    public static Result match(Player player, Computer computer) {
        int strikeCount = computer.getTargetNumbers().countStrike(player.getGameNumbers());
        return new Result();
    }
}
