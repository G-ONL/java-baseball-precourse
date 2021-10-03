package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumberTest {

    @Test
    void game_number_생성() {
        GameNumber gameNumber = new GameNumber(1);
        assertThat(gameNumber.getNumber()).isEqualTo(1);
    }
}
