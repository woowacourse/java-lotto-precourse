package com.nekisse;

import com.nekisse.domain.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 금액_생성() {
        Money money = new Money(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 금액_0원_생성불가() {
        Money money = new Money(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 금액_1000단위_아니면_생성_불가() {
        Money money = new Money(1200);
    }

    @Test
    public void 구매구입_로또_갯수_확인() {
        Money money = new Money(4000);
        assertThat(money.buyLottoCount()).isEqualTo(4);
    }

    @Test
    public void _3000원_투자_5등_당첨_3개_일때_수익률() {
        Money money = new Money(3000);
        Lotto fifthLotto= Lotto.of(1, 2, 3, 7, 8, 9);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.getBasicNumber(7));
        UserLottos userLottos = new UserLottos();
        for (int i = 0; i < 3; i++) {
            userLottos.add(fifthLotto);
        }

        LottoResult lottoResult = new LottoResult(winningLotto, userLottos);
        //15000 / 3000 = 5
        assertThat(money.getProfits(lottoResult)).isEqualTo(5);
    }
}