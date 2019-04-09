package com.molt3nrock.lotto;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class LottoBuilderTest {

    @Test
    public void build() {
        List<Lotto> lottoList;
        lottoList = LottoBuilder.create().withMoney(1000).build();
        assertEquals(1, lottoList.size());

        lottoList = LottoBuilder.create().withMoney(99000).build();
        assertEquals(99, lottoList.size());
    }

    @Test
    public void buildIllegalNotEnough() {
        try {
            LottoBuilder.create().withMoney(999).build();
        } catch (IllegalArgumentException e) {
            assertEquals("로또를 구입하기에 돈이 충분하지 않습니다.", e.getMessage());
        }
    }

    @Test
    public void buildIllegalNegative() {
        try {
            LottoBuilder.create().withMoney(-1).build();
        } catch (IllegalArgumentException e) {
            assertEquals("로또를 구입하기에 돈이 충분하지 않습니다.", e.getMessage());
        }
    }
}