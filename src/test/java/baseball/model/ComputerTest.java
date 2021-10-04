package baseball.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ComputerTest {

    @Test
    void 컴퓨터_랜덤_게임_넘버_생성() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            Computer computer = new Computer(BaseBallGame.createRandomGameNumbers());
            assertThat(computer.getGameNumbers()).isInstanceOf(GameNumbers.class);
            assertThat(computer.getGameNumbers().getGameNumber(0)).isEqualTo(new GameNumber(1));
        }
    }
}
