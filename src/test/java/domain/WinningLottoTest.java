package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WinningLottoTest {
    @Test
    public void matchTest() {
        List<Integer> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        Lotto lotto = new Lotto(lottoNumbers);

        WinningLotto winningLotto = new WinningLotto(lotto,7);

        assertEquals(Rank.FIRST, winningLotto.match(lotto));
    }
}