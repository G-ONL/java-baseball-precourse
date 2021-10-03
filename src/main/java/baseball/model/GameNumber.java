package baseball.model;

public class GameNumber {

    private int number;

    public GameNumber(int input) {
        this.number = Character.getNumericValue(input);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameNumber that = (GameNumber) o;
        return number == that.getNumber();
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
