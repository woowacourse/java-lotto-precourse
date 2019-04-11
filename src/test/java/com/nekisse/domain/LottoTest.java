package com.nekisse.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 같은_번호_갯수_3개() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        Lotto threeSameNumber = Lotto.of(1, 2, 3, 7, 8, 9);
        assertThat(lotto.matchGetSameNumberCount(threeSameNumber)).isEqualTo(3);
    }

    @Test
    public void 같은_번호가_없으면_False() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.isContainsNum(LottoNumber.getBasicNumber(7))).isFalse();
    }
}