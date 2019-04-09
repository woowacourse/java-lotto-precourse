package domain;

import java.util.Random;
import java.util.List;

public class LottoNumGenerator {

    public static final int LOTTO_NUM_LOWER_BOUND = 1;
    public static final int LOTTO_NUM_UPPER_BOUND = 45;

    private final Random random;

    public LottoNumGenerator() {
        random = new Random();
    }

    public int generateNonDuplicateLottoNum(List<Integer> lottoNums) {
        int num = generateLottoNumInRangeFromLowerBoundToUpperBound();
        while (lottoNums.contains(num)) {
            num = generateLottoNumInRangeFromLowerBoundToUpperBound();
        }
        return num;
    }

    private int generateLottoNumInRangeFromLowerBoundToUpperBound() {
        return random.nextInt(LOTTO_NUM_UPPER_BOUND) + 1;
    }
}
