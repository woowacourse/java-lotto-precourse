package com.nekisse.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호가_중복_일때_익셉션() {
        new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.getBasicNumber(1));
    }

    @Test
    public void 보너스볼일치_2등확인() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.getBasicNumber(7));
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 4, 5, 7))).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 보너스볼_불일치_3등확인() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.getBasicNumber(7));
        assertThat(winningLotto.match(Lotto.of(1, 2, 3, 4, 5, 8))).isEqualTo(Rank.THIRD);
    }

}