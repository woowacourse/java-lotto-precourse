package com.molt3nrock.lotto;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    private List<Lotto> lottoList;
    private WinningLotto winningLotto;

    @Before
    public void setUp() {
        lottoList = Stream.of(
            Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7),
            Arrays.asList(1, 2, 3, 4, 5, 8), Arrays.asList(1, 2, 3, 4, 8, 9),
            Arrays.asList(1, 2, 3, 8, 9, 10), Arrays.asList(1, 2, 8, 9, 10, 11),
            Arrays.asList(1, 8, 9, 10, 11, 12), Arrays.asList(8, 9, 10, 11, 12, 13)
        ).map(Lotto::new).collect(Collectors.toList());
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    public void numberOfRank() {
        Statistics statistics = Statistics.valueOf(lottoList, winningLotto);
        assertEquals(1, statistics.numberOfRank(Rank.FIRST));
        assertEquals(1, statistics.numberOfRank(Rank.SECOND));
        assertEquals(1, statistics.numberOfRank(Rank.THIRD));
        assertEquals(1, statistics.numberOfRank(Rank.FOURTH));
        assertEquals(1, statistics.numberOfRank(Rank.FIFTH));
        assertEquals(3, statistics.numberOfRank(Rank.MISS));
    }
}