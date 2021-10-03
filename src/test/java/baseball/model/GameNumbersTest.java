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

    @DisplayName("1이 숫자, 위치가 맞아서 1개 count 성공")
    @Test
    void 스트라이크_세기() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            computerNumbers = new Computer().getTargetNumbers();
        }
        assertThat(playerNumbers.countStrike(computerNumbers)).isEqualTo(1);
    }
    
    @Test
    void 스트라이크_세기_0개() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3, 1, 2);
            computerNumbers = new Computer().getTargetNumbers();
        }
        assertThat(playerNumbers.countStrike(computerNumbers)).isEqualTo(0);
    }
}
