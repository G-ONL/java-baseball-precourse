package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 게임결과_스트라이크(){
        Result result = new Result(0,1);
        assertThat(result.gameResult()).isEqualTo("1스트라이크");
    }

    @Test
    void 게임결과_볼() {
        Result result = new Result(1,0);
        assertThat(result.gameResult()).isEqualTo("1볼");
    }

    @Test
    void 게임결과_스트라이크_볼(){
        Result result = new Result(1,1);
        assertThat(result.gameResult()).isEqualTo("1스트라이크 1볼");
    }

    @Test
    void 게임결과_낫싱() {
        Result result = new Result(0,0);
        assertThat(result.gameResult()).isEqualTo("낫싱");
    }

    @Test
    void 게임결과_3스트라이크_게임끝(){
        Result result = new Result(0,3);
        assertThat(result.gameResult()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
