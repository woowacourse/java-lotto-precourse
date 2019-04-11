package com.nekisse;

import com.nekisse.domain.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WininngLottoGeneratorTest {
    @Test
    public void 입력_숫자_로또_생성() {
        Lotto lotto = WininngLottoGenerator.createLotto("1,2,3,4,5,6");
        assertThat(lotto.getNumbers().get(3)).isEqualTo(4);
    }
}