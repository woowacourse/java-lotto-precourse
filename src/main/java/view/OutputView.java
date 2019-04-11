package view;

import domain.Lotto;
import domain.LottoResult;
import domain.Rank;
import util.LottoGenerator;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private final static String OUTPUT_STATISTICS_PATTERN_EXCEPT_SECOND_PRIZE = "{0}개 일치 ({1}원)- {2}개";
    private final static String OUTPUT_STATISTICS_PATTERN_ONLY_SECOND_PRIZE = "{0}개 일치 보너스볼 일치({1}원) - {2}개";
    private final static String OUTPUT_PURCHASED_LOTTO_COUNT_MENT = "개 구매했습니다.";
    private final static String OUTPUT_EARNING_RATE_MENT_FIRST = "총 수익률은 ";
    private final static String OUTPUT_EARNING_RATE_MENT_SECOND = "입니다.";
    private final static String OUTPUT_WIN_STATISTICS_MENT = "당첨 통계";
    private final static String OUTPUT_DIVISION_MENT = "---------";

    public static void printResultMent(LottoResult lottoResult) {
        System.out.println(OUTPUT_WIN_STATISTICS_MENT);
        System.out.println(OUTPUT_DIVISION_MENT);
        lottoResult.getLottoResults().forEach((rank, count) -> {
            printStatistics(rank, count);
        });
    }

    public static void printStatistics(Rank rank, int rankCount) {
        if (rank.equals(Rank.SECOND)) {
            System.out.println(MessageFormat.format(OUTPUT_STATISTICS_PATTERN_ONLY_SECOND_PRIZE, rank.getCountOfMatch(), rank.getWinningMoney(), rankCount));
            return;
        }
        System.out.println(MessageFormat.format(OUTPUT_STATISTICS_PATTERN_EXCEPT_SECOND_PRIZE, rank.getCountOfMatch(), rank.getWinningMoney(), rankCount));
    }

    public static void printEarningRateMent(String earningRate) {
        System.out.println(OUTPUT_EARNING_RATE_MENT_FIRST + earningRate + OUTPUT_EARNING_RATE_MENT_SECOND);
    }

    public static void printPurchasedLottoCount(List<Lotto> lottoList, int money) {
        System.out.println(money / LottoGenerator.LOTTO_UNIT_AMOUNT + OUTPUT_PURCHASED_LOTTO_COUNT_MENT);
        lottoList.forEach(System.out::println);
    }
}
