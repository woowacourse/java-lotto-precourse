package domain;

import org.junit.Test;

import java.util.Arrays;

public class WinningLottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 보너스_번호가_0일_경우_예외처리() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNo = 0;
        new WinningLotto(lotto, bonusNo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스_번호가_당첨_번호에_포함될_경우_예외처리() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNo = 1;
        new WinningLotto(lotto, bonusNo);
    }
}