package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class LottoTest {
    @Test
    public void isLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++){
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        List<Integer> targetNumber = lottoNumbers.subList(0,5);
        Lotto lotto = new Lotto(targetNumber);
        assertEquals(targetNumber, lotto.getLottoNumbers());
    }

    @Test
    public void lottoNumberTest() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        Lotto lotto = new Lotto(lottoNumbers);
        assertEquals(lottoNumbers, lotto.getLottoNumbers());
    }
}
