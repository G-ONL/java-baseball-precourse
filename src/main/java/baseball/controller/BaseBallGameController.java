package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Result;
import baseball.view.InputView;

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

    public static boolean isGameContinue() {
        do {
            int gameContinueNumber = InputView.inputGameContinue();
            if ((gameContinueNumber) == 1) {
                return true;
            }
            if (gameContinueNumber == 2) {
                return false;
            }
        } while (true);
    }
}
