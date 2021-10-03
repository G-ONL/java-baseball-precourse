package baseball.controller;

import baseball.common.BaseBallConstants;
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
        int gameContinueNumber = InputView.inputGameContinue();
        if (gameContinueNumber == BaseBallConstants.CONTINUE) {
            return true;
        }
        return false;
    }
}
