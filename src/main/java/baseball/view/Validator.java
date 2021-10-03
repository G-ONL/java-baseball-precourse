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

    private static boolean isNumber(String input) {
        char[] inputChars = input.toCharArray();
        for (char inputChar : inputChars) {
            throwExceptionWhenIsNotTrue(!Character.isDigit(inputChar));
        }
        return true;
    }

    private static boolean isOneOrTwo(String input) {
        throwExceptionWhenIsNotTrue(!(input.equals("1") || input.equals("2")));
        return true;
    }

    private static boolean lengthCheck(Set value) {
        throwExceptionWhenIsNotTrue(value.size() != BaseBallConstants.GAME_RULE_LENGTH);
        return true;
    }

    private static boolean isZero(int input) {
        throwExceptionWhenIsNotTrue(input == 0);
        return false;
    }

    private static boolean lengthCheck(String input) {
        throwExceptionWhenIsNotTrue(input.length() != BaseBallConstants.GAME_RULE_LENGTH);
        return true;
    }

    private static boolean isContainZero(String input) {
        throwExceptionWhenIsNotTrue(input.contains("0"));
        return true;
    }

    private static boolean isEmpty(String input) {
        throwExceptionWhenIsNotTrue(input == null || input == "");
        return true;
    }

    private static void throwExceptionWhenIsNotTrue(boolean isThrowException) {
        if (isThrowException) {
            throw new IllegalArgumentException(ViewConstants.REQUEST_RE_INPUT_NUMBER);
        }
    }
}
