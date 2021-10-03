package baseball.view;

import java.util.Set;

public class Validator {
    private final static int GAME_RULE_LENGTH = 3;

    public static boolean isValidGameNumbers(Set numbers) {
        try {
            Validator.lengthCheck(numbers);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidGameNumber(int input) {
        try {
            Validator.isZero(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidInput(String input) {
        try {
            Validator.isEmpty(input);
            Validator.lengthCheck(input);
            Validator.isNumber(input);
            Validator.isContainZero(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean lengthCheck(Set value) {
        if (value.size() != GAME_RULE_LENGTH) {
            throw new IllegalArgumentException("ERROR");
        }
        return true;
    }

    private static boolean isZero(int input) {
        if (input == 0) {
            throw new IllegalArgumentException("ERROR");
        }
        return false;
    }

    private static boolean lengthCheck(String input) {
        if (input.length() != GAME_RULE_LENGTH) {
            throw new IllegalArgumentException("ERROR");
        }
        return true;
    }

    private static boolean isNumber(String input) {
        char[] inputChars = input.toCharArray();
        for (char inputChar : inputChars) {
            if (!Character.isDigit(inputChar)) {
                throw new IllegalArgumentException("ERROR");
            }
        }
        return true;
    }

    private static boolean isContainZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("ERROR");
        }
        return true;
    }

    private static boolean isEmpty(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException("ERROR");
        }
        return true;
    }
}
