package baseball.view;

import nextstep.utils.Console;

public class InputView {

    public static String inputGameNumber() {
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidInputGameNumber(input));
        return input;
    }

    public static int inputGameContinue() {
        String input;
        do {
            OutputView.output("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
            input = Console.readLine();
        } while (!Validator.isValidInputGameContinue(input));
        return Integer.parseInt(input);
    }
}
