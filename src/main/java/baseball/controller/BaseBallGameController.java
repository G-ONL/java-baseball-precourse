package baseball.controller;

import baseball.model.*;

public class BaseBallGameController {

    public static void gameStart() {
        Computer computer = new Computer();
        Result result;
        do {
            Player player = new Player(BaseBallGame.createGameNumbers());
            result = GameMather.match(player, computer);
        } while (result.isContinue());
        //return result
    }


}
