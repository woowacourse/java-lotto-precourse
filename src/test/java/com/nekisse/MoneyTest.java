package com.nekisse;

import com.nekisse.domain.Money;
import org.junit.Test;

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
}