package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1 / set {1,2,3} / size / return 3")
    @Test
    void set_size_3() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2 / set {1,2,3} / contains(1,2,3) / return true ")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_contains_number_true(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항 3 / set {1,2,3} / contains(1,2,3) contains(4,5) / return true, false")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void set_contains_number_all(int number, boolean isContained) {
        assertEquals(numbers.contains(number), isContained);
    }
}
