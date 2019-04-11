package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

public class WinningLottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 보너스볼_중복_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 1);
    }
}
