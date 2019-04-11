package lotto.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLottoTest {
    public List<Lotto> lottos;

    @Before
    public void setup() {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 10, 9)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 19, 10, 9)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 10, 15, 17, 18)));
    }

    @Test
    public void 매치_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        List<Rank> expected = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS);

        for (int i = 0; i < lottos.size(); i++)
            Assert.assertEquals(expected.get(i), winningLotto.match(lottos.get(i)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스볼_중복_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 1);
    }
}
