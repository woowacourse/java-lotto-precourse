package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 일등당첨() {
        //given
        List<Integer> winningLottoNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userLottoNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonunBall = 7;
        Lotto winningLotto = new Lotto(winningLottoNumbersList);
        Lotto userLotto = new Lotto(userLottoNumbersList);
        WinningLotto winningLotto1 = new WinningLotto(winningLotto, bonunBall);

        //when
        Rank resultRank = winningLotto1.match(userLotto);

        //then
        assertThat(resultRank).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 이등당첨() {
        //given
        List<Integer> winningLottoNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userLottoNumbersList = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonunBall = 7;
        Lotto winningLotto = new Lotto(winningLottoNumbersList);
        Lotto userLotto = new Lotto(userLottoNumbersList);
        WinningLotto winningLotto1 = new WinningLotto(winningLotto, bonunBall);

        //when
        Rank resultRank = winningLotto1.match(userLotto);

        //then
        assertThat(resultRank).isEqualTo(Rank.SECOND);
    }
}