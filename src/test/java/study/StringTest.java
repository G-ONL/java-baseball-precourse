package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("regex가 포함된 문자열에서 split 한 경우")
    @Test
    void regex_포함된_문자열() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("regex가 포함되지 않은 문자열에서 split 한 경우")
    @Test
    void regex_포함_안된_문자열() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }
}
