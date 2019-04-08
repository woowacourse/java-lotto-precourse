package Util;

import domain.Lotto;
import org.junit.Test;

public class LottoMakerTest {

    @Test
    public void getLottoTest() {
        Lotto lotto = LottoMaker.getLotto();
        System.out.println(lotto.getNumbers());
    }
}
