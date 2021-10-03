package baseball.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("위치와 숫자가 같은게 1개 return 1")
    @Test
    void 스트라이크_세기_위치_숫자_같은_것이_1개() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            computerNumbers = new Computer().getTargetNumbers();
        }
        assertThat(playerNumbers.countStrike(computerNumbers)).isEqualTo(1);
    }

    @DisplayName("위치만 다르고, 숫자는 같음 return 0")
    @Test
    void 스트라이크_세기_숫자가_같고_위치가_다름() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3, 1, 2);
            computerNumbers = new Computer().getTargetNumbers();
        }
        assertThat(playerNumbers.countStrike(computerNumbers)).isEqualTo(0);
    }

    @DisplayName("위치만 다르고, 숫자는 같음 return 3")
    @Test
    void 볼_세기_숫자가_같고_위치가_다름() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3, 1, 2);
            computerNumbers = new Computer().getTargetNumbers();
        }
        assertThat(playerNumbers.countBall(computerNumbers)).isEqualTo(3);
    }

    @DisplayName("위치가 같고, 숫자도 같음 return 0")
    @Test
    void 볼_세기_숫자가_같고_위치가_같음() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 2, 3);
            computerNumbers = new Computer().getTargetNumbers();
        }
        assertThat(playerNumbers.countBall(computerNumbers)).isEqualTo(0);
    }
}
