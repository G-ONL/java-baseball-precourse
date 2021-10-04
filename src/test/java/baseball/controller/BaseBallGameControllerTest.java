package baseball.controller;

import nextstep.utils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

public class BaseBallGameControllerTest {

    @DisplayName("1이면 True, 2면 False")
    @ParameterizedTest
    @CsvSource({"1,true", "2,false"})
    void 게임_지속_여부_숫자_1이면_true_2면_false(String input, boolean isContinue) {
        try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine())
                    .thenReturn(input);
            assertThat(BaseBallGameController.isGameContinue()).isEqualTo(isContinue);
        }
    }
}