package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 볼0개_스트라이크_1개_일_때_게임결과_1스트라이크() {
        Result result = new Result(0, 1);
        assertThat(result.gameResult()).isEqualTo("1스트라이크");
    }

    @Test
    void 볼1개_스트라이크_0개_일_때_게임결과_1볼() {
        Result result = new Result(1, 0);
        assertThat(result.gameResult()).isEqualTo("1볼");
    }

    @Test
    void 볼1개_스트라이크_1개_일_때_게임결과_1스트라이크_1볼() {
        Result result = new Result(1, 1);
        assertThat(result.gameResult()).isEqualTo("1스트라이크 1볼");
    }

    @Test
    void 볼0개_스트라이크_0개_일_때_게임결과_낫싱() {
        Result result = new Result(0, 0);
        assertThat(result.gameResult()).isEqualTo("낫싱");
    }

    @Test
    void 볼0개_스트라이크_3개_일_때_게임결과_3스트라이크_게임끝() {
        Result result = new Result(0, 3);
        assertThat(result.gameResult()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    @Test
    void 스트라이크_3개_일_때_게임_지속_False() {
        Result result = new Result(0, 3);
        assertThat(result.isMatchContinue()).isFalse();
    }

    @Test
    void 스트라이크_3개가_아닐_때_게임_지속_True() {
        Result result = new Result(1, 1);
        assertThat(result.isMatchContinue()).isTrue();
    }
}
