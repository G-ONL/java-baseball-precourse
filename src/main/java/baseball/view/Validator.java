package baseball.view;

import java.util.Set;

public class Validator {
    private final static int GAME_RULE_LENGTH = 3;

    public static boolean lengthCheck(Set value) {
        return value.size() == GAME_RULE_LENGTH;
    }

    public static boolean isNumber(char input) {
        return Character.isDigit(input);
    }

    public static boolean isZero(char input) {
        return Character.getNumericValue(input) == 0;
    }
}
