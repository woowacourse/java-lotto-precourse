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
}