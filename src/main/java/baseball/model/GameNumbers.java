package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class GameNumbers {

    private Set<GameNumber> numbers = new HashSet<>();

    public GameNumbers(Set<GameNumber> numbers) {
        this.numbers = numbers;
    }
}
