package baseball.model;

import baseball.view.InputView;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class BaseBallGameTest {

    @DisplayName("생성 시 length check를 해줌")
    @Test
    void game_numbers_생성() {
        try (final MockedStatic<InputView> mockInputViews = mockStatic(InputView.class)) {
            mockInputViews
                    .when(() -> InputView.inputGameNumber())
                    .thenReturn("9876")
                    .thenReturn("12")
                    .thenReturn("456");
            GameNumbers gameNumbers = BaseBallGame.createGameNumbers();
            assertThat(gameNumbers).isInstanceOf(GameNumbers.class);
            assertThat(gameNumbers.getGameNumber(1)).isEqualTo(new GameNumber(5));
        }
    }

    @DisplayName("player와 computer match return result ")
    @Test
    void match_1스트라이크_1볼(){
        try (final MockedStatic<InputView> mockInputViews = mockStatic(InputView.class);
             final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockInputViews
                    .when(() -> InputView.inputGameNumber())
                    .thenReturn("9876")
                    .thenReturn("12")
                    .thenReturn("365");
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            Player player = new Player(BaseBallGame.createGameNumbers());
            Computer computer = new Computer(BaseBallGame.createRandomGameNumbers());
            assertThat(BaseBallGame.match(player,computer).gameResult()).isEqualTo("1스트라이크 1볼");
        }
        
    }
}
