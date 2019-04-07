package domain;

import java.util.Random;

public class LottoNumGenerator {

    public static final int LOTTO_NUM_LOWER_BOUND = 1;
    public static final int LOTTO_NUM_UPPER_BOUND = 45;

    private final Random random;

    public LottoNumGenerator() {
        random = new Random();
    }

    public int generate() {
        return generateLottoNumInRangeFromLowerBoundToUpperBound();
    }

    private int generateLottoNumInRangeFromLowerBoundToUpperBound() {
        return random.nextInt(LOTTO_NUM_UPPER_BOUND) + 1;
    }
}
