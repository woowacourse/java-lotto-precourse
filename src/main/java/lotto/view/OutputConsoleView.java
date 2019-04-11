package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.Rank;
import lotto.domain.WinPrice;

import java.util.List;

public class OutputConsoleView {

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos)
            System.out.println(lotto);
    }

    public static void printResult(WinPrice winPrice) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values())
            printWinPrice(rank, winPrice);
    }

    private static void printWinPrice(Rank rank, WinPrice winPrice) {
        if (isMiss(rank))
            return;

        System.out.println(String.format("%d개 일치%s(%d원)- %d개",
                rank.getCountOfMatch(),
                rank.equals(Rank.SECOND) ? ", 보너스 볼 일치" : " ",
                rank.getWinningMoney(),
                winPrice.getWinCount(rank)));
    }

    private static boolean isMiss(Rank rank) {
        return Rank.MISS == rank;
    }

    public static void printRateOfProfit(LottoMoney purchaseAmount, long totalWinPrice) {
        System.out.println("총 수익률은 " + calculateRateOfProfit(purchaseAmount, totalWinPrice) + "%입니다.");
    }

    protected static double calculateRateOfProfit(LottoMoney purchaseAmount, long totalWinPrice) {
        return (double) totalWinPrice / purchaseAmount.getPurchaseAmount() * 100;
    }
}
