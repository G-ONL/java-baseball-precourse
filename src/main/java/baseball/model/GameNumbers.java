package baseball.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class GameNumbers {

    private Set<GameNumber> numbers = new LinkedHashSet<>();

    public GameNumbers(Set<GameNumber> numbers) {
        this.numbers = numbers;
    }
}
