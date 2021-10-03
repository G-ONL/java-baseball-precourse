package baseball.model;

import baseball.view.InputView;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

public class BaseBallGameTest {

    @Test
    void game_numbers_create() {
        try (final MockedStatic<InputView> mockInputViews = mockStatic(InputView.class)) {
            mockInputViews
                    .when(() -> InputView.inputGameNumber())
                    .thenReturn("123");
            assertThat(BaseBallGame.createGameNumbers()).isInstanceOf(GameNumbers.class);
        }
    }
}
