package domain.util;

public class CheckException {
    public static void checkValueInRange(int value, int min, int max) {
        if (value >= min && value <= max) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void checkWinNumberLength(int value, int lottoNum) {
        if (value == lottoNum) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
