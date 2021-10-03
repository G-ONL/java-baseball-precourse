package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.Computer;
import baseball.model.Player;

public class BaseBallGameController {

    public static void gameStart() {
        Computer computer = new Computer();
        do {
            Player player = new Player(BaseBallGame.createGameNumbers());
        } while (false);
        //return result
    }


}
