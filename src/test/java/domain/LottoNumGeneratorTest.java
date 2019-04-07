package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNumGeneratorTest {

    @Test
    public void testLottoNumIsNotValidIfLottoNumExceedBound() {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_UPPER_BOUND;
        LottoNumGenerator lottoNumGenerator = new LottoNumGenerator();

        int lottoNum = lottoNumGenerator.generate();

        assertFalse((lottoNum < lowerBound) || (lottoNum > upperBound));
    }
}