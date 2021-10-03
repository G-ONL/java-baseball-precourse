package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Result;

public class BaseBallGameController {

    public static void gameStart() {
        Computer computer = new Computer();
        Result result;
        do {
            Player player = new Player(BaseBallGame.createGameNumbers());
            result = BaseBallGame.match(player, computer);
            BaseBallGame.gameResult(result);
        } while (result.isMatchContinue());
    }


}
