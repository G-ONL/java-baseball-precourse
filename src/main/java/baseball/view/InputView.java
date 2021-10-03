package baseball.view;

import baseball.common.ViewConstants;
import nextstep.utils.Console;

public class InputView {

    public static String inputGameNumber() {
        String input;
        do {
            OutputView.outputNotLineBreak(ViewConstants.REQUEST_INPUT_NUMBER);
            input = Console.readLine();
        } while (!Validator.isValidInputGameNumber(input));
        return input;
    }

    public static int inputGameContinue() {
        String input;
        do {
            OutputView.output(ViewConstants.REQUEST_CONTINUE);
            input = Console.readLine();
        } while (!Validator.isValidInputGameContinue(input));
        return Integer.parseInt(input);
    }
}
