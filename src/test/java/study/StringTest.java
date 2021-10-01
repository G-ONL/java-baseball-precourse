package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    private String regex = ",";

    @DisplayName("요구사항1 / 콤마가 포함된 문자열 / split / return split된 배열")
    @Test
    void 콤마가_포함된_문자열_콤마_기준으로_split() {
        final String regexWithSentence = "1,2";
        final String[] actual = regexWithSentence.split(regex);
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("요구사항1 / 콤마가 포함되지 않은 문자열 / split / return split되지 않은 배열")
    @Test
    void 콤마가_포함_안된_문자열_콤마_기준으로_split() {
        final String regexWithoutSentence = "1";
        final String[] actual = regexWithoutSentence.split(regex);
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("요구사항2 / 괄호가 맨 앞, 맨 뒤로 포함된 문자열 / substring / return 괄호가 제거된 문자열")
    @Test
    void 괄호가_포함_된_문자열_substring() {
        final String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 / abc 문자열 / charAt(0) / return a")
    @Test
    void abc_index_0번_위치는_문자_a() {
        final char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @DisplayName("요구사항3 / abc 문자열 / charAt(4) / throws StringIndexOutOfBoundsException")
    @Test
    void abc_index_4번_위치는_exception() {
        final String exceptionMessage = "String index out of range: 4";
        assertThatThrownBy(() -> {
            final char actual = "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(exceptionMessage);
    }

}
