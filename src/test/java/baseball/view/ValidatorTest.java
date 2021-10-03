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

    @DisplayName("길이가 3가 아닌, 숫자가 아닌, 빈 문자열, null, 0이 포함된 경우 return false")
    @ParameterizedTest
    @CsvSource(value = {"1234,false", "문자열,false", "null,false", " ,false", ",false", "012,false",}, nullValues = {"null"})
    void 인풋값_길이_3이_아니거나_문자이거나_0포함_일_경우_false(String input, boolean isValid) {
        assertEquals(Validator.isValidInputGameNumber(input), isValid);
    }

    @DisplayName("길이가 3가 이고, 숫자, 0이 포함 안 된 경우 return true")
    @Test
    void 인풋값_길이_3이고_숫자이고_0이_없을경우_true() {
        String input = "123";
        assertThat(Validator.isValidInputGameNumber(input)).isTrue();
    }

    @DisplayName("1,2가 아니거나, 문자, 빈 문자열, null, 0이 포함된 경우 return false")
    @ParameterizedTest
    @CsvSource(value = {"1234,false", "문자열,false", "null,false", " ,false", ",false", "3,false",}, nullValues = {"null"})
    void 인풋값_1_2가_아니면_false(String input, boolean isValid) {
        assertEquals(Validator.isValidInputGameContinue(input), isValid);
    }

    @DisplayName("1,2인 경우 return true")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true"})
    void 인풋값_1_2면_true(String input, boolean isValid) {
        assertEquals(Validator.isValidInputGameContinue(input), isValid);
    }

    @DisplayName("0인 경우 return false")
    @Test
    void game_number_0인_경우_false() {
        Validator.isValidGameNumber(0);
    }

    @DisplayName("0이 아닌 경우 return true")
    @Test
    void game_number_0이_아닌_경우_성공() {
        assertThat(Validator.isValidGameNumber(1)).isTrue();
    }

    @DisplayName("길이가 3이 아닌 경우 return false")
    @Test
    void game_numbers_size_3이_아닌_경우_false() {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        assertThat(Validator.isValidGameNumbers(integers)).isFalse();
    }

    @DisplayName("길이가 3인 경우 return true")
    @Test
    void game_numbers_size_3인_경우_true() {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        assertThat(Validator.isValidGameNumbers(integers)).isTrue();
    }
}
