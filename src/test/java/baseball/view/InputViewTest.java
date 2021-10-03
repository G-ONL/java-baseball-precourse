package baseball.view;

import nextstep.utils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

public class InputViewTest {

    @DisplayName("3인 숫자가 아닐 때는 재입력 요청")
    @Test
    void 길이가_3인_숫자_입력받기() {
        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine())
                    .thenReturn("1111")
                    .thenReturn("102")
                    .thenReturn("안녕하세요")
                    .thenReturn(null)
                    .thenReturn("")
                    .thenReturn(" ")
                    .thenReturn("713");
            assertThat(InputView.inputGameNumber()).isEqualTo("713");
        }
    }

    @DisplayName("숫자 1,2만 입력받고 나머지는 재입력 요청")
    @Test
    void 숫자_1_2만_입력받기() {
        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine())
                    .thenReturn("1111")
                    .thenReturn("3")
                    .thenReturn("안녕하세요")
                    .thenReturn(null)
                    .thenReturn("")
                    .thenReturn(" ")
                    .thenReturn("1")
                    .thenReturn("2");
            assertThat(InputView.inputGameContinue()).isEqualTo(1);
            assertThat(InputView.inputGameContinue()).isEqualTo(2);
        }
    }

}
