package com.molt3nrock.lotto;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @Before
    public void setUp() {
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    public void match1stRank() {
        Rank rank = winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertEquals(Rank.FIRST, rank);
    }

    @Test
    public void match2ndRank() {
        Rank rank = winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertEquals(Rank.SECOND, rank);
    }

    @Test
    public void match3rdRank() {
        Rank rank = winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        assertEquals(Rank.THIRD, rank);
    }

    @Test
    public void match4thRank() {
        Rank rank = winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        assertEquals(Rank.FOURTH, rank);
    }

    @Test
    public void match5thRank() {
        Rank rank = winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)));
        assertEquals(Rank.FIFTH, rank);
    }

    @Test
    public void matchNoRank() {
        Lotto noMatchLotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
        Lotto singleMatchLotto = new Lotto(Arrays.asList(1, 8, 9, 10, 11, 12));
        Lotto doubleMatchLotto = new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11));
        Boolean actual = Stream.of(noMatchLotto, singleMatchLotto, doubleMatchLotto)
            .allMatch(lotto -> winningLotto.match(lotto).equals(Rank.MISS));
        assertEquals(true, actual);
    }
}