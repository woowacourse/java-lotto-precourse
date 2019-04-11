package com.nekisse.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void 로또넘버생성() {
        LottoNumber basicNumber = LottoNumber.getBasicNumber(1);
        assertThat(basicNumber.toString()).isEqualTo("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_넘버_범위_테스트_0() {
        LottoNumber basicNumber = LottoNumber.getBasicNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_넘버_범위_테스트_음수() {
        LottoNumber basicNumber = LottoNumber.getBasicNumber(-4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_넘버_범위_테스트_46() {
        LottoNumber basicNumber = LottoNumber.getBasicNumber(46);
    }



}