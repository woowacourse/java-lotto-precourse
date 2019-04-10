package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @Before
    public void setUp() {
        lottoResult = LottoResult.getInstance();
    }

    @Test
    public void 일등한개_네개탈락() {
        //given
        int bonusBall = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), bonusBall);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(10, 11, 13, 14, 15, 16)));
        lottoList.add(new Lotto(Arrays.asList(12, 22, 32, 42, 43, 44)));
        lottoList.add(new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26)));
        lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 34, 35, 36)));
        lottoList.forEach(lotto -> {
            lottoResult.insertResult(winningLotto.match(lotto));
        });

        //when
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResults();

        //then
        assertThat(lottoResultMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResultMap.get(Rank.MISS)).isEqualTo(4);
    }
}