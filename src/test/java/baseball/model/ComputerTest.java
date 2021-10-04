package baseball.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ComputerTest {

    @Test
    void 컴퓨터_생성_테스트() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            Computer computer = new Computer(BaseBallGame.createRandomGameNumbers());
            int index = 0;
            assertThat(computer.getGameNumbers()).isInstanceOf(GameNumbers.class);
            assertThat(computer.getGameNumbers().getGameNumber(index)).isEqualTo(new GameNumber(1));
        }
    }
}
