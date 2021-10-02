package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    @DisplayName("문자가 포함되어 있으면 false, 오직 숫자면 true")
    @ParameterizedTest
    @CsvSource({"1,true", "문,false"})
    void 문자_여부_판별(char value, boolean isOnlyNumber) {
        assertEquals(Validator.isNumber(value), isOnlyNumber);
    }

    @DisplayName("숫자0이 포함되어 있으면 true, 아니면 false")
    @ParameterizedTest
    @CsvSource({"0,true", "1,false", "아,false"})
    void 숫자_0을_포함_여부_판별(char value, boolean isContainZero) {
        assertEquals(Validator.isZero(value), isContainZero);
    }

    @DisplayName("Set의 요소가 3개이면 true, 아니면 false")
    @Test
    void Set_길이_3_일_때_True() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        assertThat(Validator.lengthCheck(numbers)).isTrue();
    }
}
