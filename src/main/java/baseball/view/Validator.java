package baseball.view;

public class Validator {
    private final static int GAME_RULE_LENGTH = 3;

    public static boolean lengthCheck(String value) {
        return value.length() == GAME_RULE_LENGTH;
    }

    public static boolean isNumber(String input) {
        char[] inputChars = input.toCharArray();
        for (char a : inputChars) {
            if (!Character.isDigit(a)) return false;
        }
        return true;
    }

    public static boolean isContainZero(String input) {
        return input.contains("0");
    }
}
