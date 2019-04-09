package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author delf
 */
public class WinningLottoTest {
    private WinningLotto winningLotto;
    private final static List<Integer> WINNING_LOTTO_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private final static int BONUS = 7;

    @Before
    public void init() {
        Lotto lotto = new Lotto(WINNING_LOTTO_NUMBERS);
        winningLotto = new WinningLotto(lotto, BONUS);
    }

    @Test
    public void 당첨_로또와_사용자_로또를_비교하여_맞는게_하나도_없다() {
        Lotto lotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13, 14));
        Rank rank = winningLotto.match(lotto);

        assertThat(rank.getCountOfMatch()).isZero();
        assertThat(rank.getWinningMoney()).isZero();
    }

    @Test
    public void 당첨_로또와_사용자_로또를_비교하여_일등에_당첨됐다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Rank rank = winningLotto.match(lotto);

        assertThat(rank.getCountOfMatch()).isEqualTo(Lotto.PICK_NUM);
        assertThat(rank.getWinningMoney()).isEqualTo(Rank.FIRST.getWinningMoney());
    }

    @Test
    public void 당첨_로또와_사용자_로또를_비교하여_이등에_당첨됐다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Rank rank = winningLotto.match(lotto);

        assertThat(rank.getCountOfMatch()).isEqualTo(Rank.SECOND.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(Rank.SECOND.getWinningMoney());
    }

    @Test
    public void 당첨_로또와_사용자_로또를_비교하여_삼등에_당첨됐다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Rank rank = winningLotto.match(lotto);

        assertThat(rank.getCountOfMatch()).isEqualTo(Rank.THIRD.getCountOfMatch());
        assertThat(rank.getWinningMoney()).isEqualTo(Rank.THIRD.getWinningMoney());
    }
}