import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLottoTest {
    private List<Lotto> lottos = new ArrayList<>();

    @Before
    public void init() {
        lottos.add(new Lotto(Arrays.asList(1, 5, 11, 23, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(1, 5, 11, 23, 29, 42)));
        lottos.add(new Lotto(Arrays.asList(5, 11, 23, 42, 43, 45)));
        lottos.add(new Lotto(Arrays.asList(11, 23, 27, 42, 43, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 7, 11, 24, 32, 43)));
    }

    @Test
    public void testMatch() {
        WinningLotto win = new WinningLotto(
            new Lotto(Arrays.asList(1, 5, 11, 23, 42, 43)), 29);

        Rank[] expecteds = new Rank[]{Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH};

        for (int i = 0; i < lottos.size(); i++) {
            Assert.assertEquals(lottos.get(i) + " / " + win + " != " + expecteds[i],
                expecteds[i], win.match(lottos.get(i)));
        }
    }

}
