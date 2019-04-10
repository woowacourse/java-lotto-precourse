package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoNumGeneratorTest {

    @Test
    public void testLottoNumIsNotValidIfLottoNumExceedBound() {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_UPPER_BOUND;
        LottoNumGenerator lottoNumGenerator = new LottoNumGenerator();

        int lottoNum = lottoNumGenerator.generateNonDuplicateLottoNum(Arrays.asList(1));

        assertFalse((lottoNum < lowerBound) || (lottoNum > upperBound));
    }
}