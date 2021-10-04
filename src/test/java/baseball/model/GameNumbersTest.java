package baseball.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class GameNumbersTest {
    GameNumbers playerNumbers;
    GameNumbers computerNumbers;

    @BeforeEach
    void init() {
        Set<GameNumber> gameNumbers = new LinkedHashSet<>();
        gameNumbers.add(new GameNumber(1));
        gameNumbers.add(new GameNumber(2));
        gameNumbers.add(new GameNumber(3));
        gameNumbers.add(new GameNumber(1));
        playerNumbers = new GameNumbers(gameNumbers);
    }

    @Nested
    class 플레이어_숫자가_123_일_때 {
        @DisplayName("123, 135 스트라이크 개수 1개 return 1")
        @Test
        void 컴퓨터_숫자_135_스트라이크_개수_1개() {
            try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
                mockRandoms
                        .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                        .thenReturn(1, 3, 5);
                computerNumbers = new Computer(BaseBallGame.createRandomGameNumbers()).getGameNumbers();
            }
            assertThat(playerNumbers.countStrike(computerNumbers)).isEqualTo(1);
        }

        @DisplayName("123, 312 스트라이크 개수 0개 return 0")
        @Test
        void 컴퓨터_숫자_312_스트라이크_개수_0개() {
            try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
                mockRandoms
                        .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                        .thenReturn(3, 1, 2);
                computerNumbers = new Computer(BaseBallGame.createRandomGameNumbers()).getGameNumbers();
            }
            assertThat(playerNumbers.countStrike(computerNumbers)).isEqualTo(0);
        }

        @DisplayName("123, 312 볼 개수 3개 return 3")
        @Test
        void 컴퓨터_숫자_312_볼_개수_3개() {
            try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
                mockRandoms
                        .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                        .thenReturn(3, 1, 2);
                computerNumbers = new Computer(BaseBallGame.createRandomGameNumbers()).getGameNumbers();
            }
            assertThat(playerNumbers.countBall(computerNumbers)).isEqualTo(3);
        }

        @DisplayName("123, 123 볼 개수 0개 return 0")
        @Test
        void 컴퓨터_숫자_123_볼_개수_0개() {
            try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
                mockRandoms
                        .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                        .thenReturn(1, 2, 3);
                computerNumbers = new Computer(BaseBallGame.createRandomGameNumbers()).getGameNumbers();
            }
            assertThat(playerNumbers.countBall(computerNumbers)).isEqualTo(0);
        }
    }


}
