package com.codemcd.lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    public void makeLottoNumber_생성된_로또_번호_중복_검사_1000번() {
        for (int test = 0; test < 1000; ++test) {
            List<Integer> lottoNumbers = RandomNumber.makeLottoNumber();
            List<Integer> countOfNumber = new ArrayList<>(46);
            int totalCountOfNumber = 0;
            for (int i = 0; i < 46; ++i) {
                countOfNumber.add(0);
            }
            for (int i = 0; i < lottoNumbers.size(); ++i) {
                countOfNumber.set(lottoNumbers.get(i), countOfNumber.get(lottoNumbers.get(i)) + 1);
            }
            for (int i = 0; i < lottoNumbers.size(); ++i) {
                assertThat(countOfNumber.get(lottoNumbers.get(i)) == 1).isTrue();
                totalCountOfNumber += countOfNumber.get(lottoNumbers.get(i));
            }
            assertThat(totalCountOfNumber == 6).isTrue();
        }
    }
}