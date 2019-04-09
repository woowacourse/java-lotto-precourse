package com.molt3nrock.lotto;

import static com.molt3nrock.lotto.Constants.PRICE_PER_LOTTO;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    private List<Lotto> lottoList;
    private WinningLotto winningLotto;
    private ByteArrayOutputStream bo;

    @Before
    public void setUp() {
        setupLottoList();
        setupWinningLotto();
        setupMockOutputStream();
    }

    @Test
    public void displayRankState() {
        Statistics statistics = Statistics.valueOf(lottoList, winningLotto);
        statistics.displayRankState();
        String expected =
            Stream.of("\n당첨 통계", "---------", "3개 일치 (5000원)- 1개", "4개 일치 (50000원)- 1개",
                      "5개 일치 (1500000원)- 1개", "5개 일치, 보너스볼 일치(30000000원)- 1개",
                      "6개 일치 (2000000000원)- 1개")
                .map(s -> s + "\n").reduce("", (a, b) -> a + b);
        assertEquals(expected, bo.toString());
    }

    @Test
    public void displayRossGainRationGain() {
        Statistics statistics = Statistics.valueOf(lottoList, winningLotto);
        int expectedGain = calcGain(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
        int expectedCost = lottoList.size() * PRICE_PER_LOTTO;
        statistics.displayRossGainRation();
        assertEquals(String.format("총 수익률은 %.3f입니다.\n", (float) expectedGain / expectedCost),
                     bo.toString());
    }

    @Test
    public void displayRossGainRationLoss() {
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(45, 44, 43, 13, 12, 11)), 4);
        Statistics statistics = Statistics.valueOf(lottoList, winningLotto);
        int expectedGain = calcGain(Rank.FIFTH);
        int expectedCost = lottoList.size() * PRICE_PER_LOTTO;
        statistics.displayRossGainRation();
        assertEquals(String.format("총 수익률은 %.3f입니다.\n", (float) expectedGain / expectedCost),
                     bo.toString());
    }

    private void setupLottoList() {
        lottoList = Stream.of(
            Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7),
            Arrays.asList(1, 2, 3, 4, 5, 8), Arrays.asList(1, 2, 3, 4, 8, 9),
            Arrays.asList(1, 2, 3, 8, 9, 10), Arrays.asList(1, 2, 8, 9, 10, 11),
            Arrays.asList(1, 8, 9, 10, 11, 12), Arrays.asList(8, 9, 10, 11, 12, 13)
        ).map(Lotto::new).collect(Collectors.toList());
    }

    private void setupWinningLotto() {
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    private void setupMockOutputStream() {
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    private int calcGain(Rank... args) {
        return Stream.of(args)
            .map(Rank::getWinningMoney).reduce(0, (accumulation, money) -> accumulation + money);
    }
}