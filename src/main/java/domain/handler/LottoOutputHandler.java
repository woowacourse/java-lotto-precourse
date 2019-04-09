package domain.handler;

import java.util.Map;

import domain.Rank;

public class LottoOutputHandler {

    private final Map<Rank, Integer> lottoEventResult;

    public LottoOutputHandler(Map<Rank, Integer> lottoEventResult) {
        this.lottoEventResult = lottoEventResult;
    }

    public void showLottoEventResult() {
        lottoEventResult.forEach((key, value) -> {
            Rank rank = key;
            printMessage(rank.getCountOfMatch() + "개 일치 ("
                    + rank.getWinningMoney() + "원) - " + value);
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

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
