package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WinningLottoTest {

    public List<Integer> getNumberOfList (int[] inputnumbers){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i ++){
            numbers.add(inputnumbers[i]);
        }
        return numbers;
    }

    @Test
    public void matchTest() {
        List<Integer> lottoNumbers;
        lottoNumbers = getNumberOfList(new int[]{1,2,3,4,5,6});

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(lotto,7);
        assertEquals(Rank.FIRST, winningLotto.match(lotto));

        lottoNumbers = getNumberOfList(new int[]{1,2,3,4,5,7});
        Lotto lotto1 = new Lotto(lottoNumbers);
        assertEquals(Rank.SECOND, winningLotto.match(lotto1));

        lottoNumbers = getNumberOfList(new int[]{3,4,5,6,2,8});
        Lotto lotto2 = new Lotto(lottoNumbers);
        assertEquals(Rank.THIRD, winningLotto.match(lotto2));

        lottoNumbers = getNumberOfList(new int[]{4,5,6,1,7,8});
        Lotto lotto3 = new Lotto(lottoNumbers);
        assertEquals(Rank.FOURTH, winningLotto.match(lotto3));

        lottoNumbers = getNumberOfList(new int[]{4,5,6,9,8,10});
        Lotto lotto4 = new Lotto(lottoNumbers);
        assertEquals(Rank.FIFTH, winningLotto.match(lotto4));

        lottoNumbers = getNumberOfList(new int[]{1,2,8,9,10,11});
        Lotto lotto5 = new Lotto(lottoNumbers);
        assertEquals(Rank.MISS, winningLotto.match(lotto5));

    }

}