package baseball.view;

import nextstep.utils.Console;

public class InputView {
    public static String input() {
        String input = Console.readLine();
        isValid(input);
        return input;
    }

    private static void isValid(String input) {
        if (!Validator.lengthCheck(input)) {
            OutputView.output("ERROR");
        }
        if (!Validator.isNumber(input)) {
            OutputView.output("ERROR");
        }
        if (Validator.isContainZero(input)) {
            OutputView.output("ERROR");
        }
    }
}
