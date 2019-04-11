package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만금액입력(){
        //given
        int money = 900;

        //when
        LottoGenerator.generateLottoList(money);
    }
}