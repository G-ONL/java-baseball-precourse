package baseball.view;

import baseball.common.BaseBallConstants;
import baseball.common.ViewConstants;

import java.util.Set;

public class Validator {

    public static boolean isValidGameNumbers(Set numbers) {
        try {
            Validator.lengthCheck(numbers);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.output(e.getMessage());
            return false;
        }
    }

    public static boolean isValidGameNumber(int input) {
        try {
            Validator.isZero(input);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.output(e.getMessage());
            return false;
        }
    }

    public static boolean isValidInputGameNumber(String input) {
        try {
            Validator.isEmpty(input);
            Validator.lengthCheck(input);
            Validator.isNumber(input);
            Validator.isContainZero(input);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.output(e.getMessage());
            return false;
        }
    }

    public static boolean isValidInputGameContinue(String input) {
        try {
            Validator.isEmpty(input);
            Validator.isNumber(input);
            Validator.isOneOrTwo(input);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.output(e.getMessage());
            return false;
        }
    }

    private static boolean isOneOrTwo(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
        }
        return true;
    }

    private static boolean lengthCheck(Set value) {
        if (value.size() != BaseBallConstants.GAME_RULE_LENGTH) {
            throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
        }
        return true;
    }

    private static boolean isZero(int input) {
        if (input == 0) {
            throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
        }
        return false;
    }

    private static boolean lengthCheck(String input) {
        if (input.length() != BaseBallConstants.GAME_RULE_LENGTH) {
            throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
        }
        return true;
    }

    private static boolean isNumber(String input) {
        char[] inputChars = input.toCharArray();
        for (char inputChar : inputChars) {
            if (!Character.isDigit(inputChar)) {
                throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
            }
        }
        return true;
    }

    private static boolean isContainZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
        }
        return true;
    }

    private static boolean isEmpty(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
        }
        return true;
    }

}
