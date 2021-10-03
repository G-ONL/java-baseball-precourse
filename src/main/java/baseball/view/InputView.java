package baseball.view;

import nextstep.utils.Console;

public class InputView {

    public static String input() {
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidInput(input));
        return input;
    }
}
