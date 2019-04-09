package domain.handler;

import java.util.Map;
import java.util.List;

import domain.Rank;
import domain.Lotto;

public class LottoOutputHandler {

    private final Map<Rank, Integer> lottoEventResult;

    public LottoOutputHandler(Map<Rank, Integer> lottoEventResult) {
        this.lottoEventResult = lottoEventResult;
    }

    public void showLottoEventResult() {
        printMessage("당첨 통계\n--------");
        lottoEventResult.forEach((key, value) -> {
            showRank(key, value);
        });
    }

    public void showProfitRate(int purchaseAmount) {
        int profit = 0;
        for (Map.Entry<Rank, Integer> entry : lottoEventResult.entrySet()) {
            int winningMoney = entry.getKey().getWinningMoney();
            int numOfWinningRank = entry.getValue();
            profit += winningMoney * numOfWinningRank;
        }
        printMessage("총 수익률은 " + (double) profit / purchaseAmount + "입니다.");
    }

    public static void showPurchasedLotto(List<Lotto> purchasedLotto) {
        printMessage(purchasedLotto.size() + "개를 구입했습니다.");
        purchasedLotto.forEach((lotto) -> {
            printMessage(lotto.toString());
        });
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private void showRank(Rank rank, Integer numOfWinningRank) {
        String additional = "";
        if (rank == Rank.SECOND) {
            additional += ", 보너스 볼 일치";
        }
        printMessage(rank.getCountOfMatch() + "개 일치" + additional
                + "(" + rank.getWinningMoney() + "원) - " + numOfWinningRank);
    }
}
