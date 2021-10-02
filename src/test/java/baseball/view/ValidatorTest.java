package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    @DisplayName("문자 길이가 3이면 True, 그 외에는 False ")
    @ParameterizedTest
    @CsvSource({"123,true", "1234,false", "문자열,true"})
    void 문자_길이_체크(String value, boolean isThreeLength) {
        assertEquals(Validator.lengthCheck(value), isThreeLength);
    }

    @DisplayName("문자가 포함되어 있으면 false, 오직 숫자면 true")
    @ParameterizedTest
    @CsvSource({"123,true", "문자1,false"})
    void 문자_포함_여부_판별(String value, boolean isOnlyNumber) {
        assertEquals(Validator.isNumber(value), isOnlyNumber);
    }

    @DisplayName("숫자0이 포함되어 있으면 true, 아니면 false")
    @ParameterizedTest
    @CsvSource({"120,true", "123,false"})
    void 숫자_0을_포함_여부_판별(String value, boolean isContainZero) {
        assertEquals(Validator.isContainZero(value), isContainZero);
    }
}
