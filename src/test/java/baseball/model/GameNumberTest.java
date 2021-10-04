package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumberTest {

    @Test
    void game_number_생성_값_비교() {
        GameNumber gameNumber = new GameNumber(1);
        assertThat(gameNumber.getNumber()).isEqualTo(1);
    }

    @Test
    void game_number_생성_개체_비교() {
        GameNumber gameNumber = new GameNumber(1);
        GameNumber gameNumber2 = new GameNumber(1);
        assertThat(gameNumber).isEqualTo(gameNumber2);
    }
}
