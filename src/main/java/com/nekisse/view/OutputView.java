package com.nekisse.view;

import com.nekisse.domain.*;

public class OutputView {
    public static void PrintUserBuyLottos(UserLottos userLottos, Money money) {
        System.out.println(money.buyLottoCount() + "개를 구매했습니다.");
        for (Lotto userLotto : userLottos.getUserLottos()) {
            System.out.println(userLotto);
        }
    }

    public static void printProfits(double profits) {
        System.out.printf("총 수익률은 %.3f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",profits);
    }

    public static void printResult(LottoResult lottoResult) {
        String format = "%d개 일치 (%d원)-  %d개\n";
        System.out.println("당첨통계\n------");
        System.out.printf(
            format, Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), lottoResult.getLottoResults().get(Rank.FIFTH));
        System.out.printf(
            format, Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), lottoResult.getLottoResults().get(Rank.FOURTH));
        System.out.printf(
            format, Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), lottoResult.getLottoResults().get(Rank.THIRD));
        System.out.println(
            Rank.SECOND.getCountOfMatch() + "개 일치 (" + Rank.SECOND.getWinningMoney() + "원)-  " + lottoResult.getLottoResults().get(Rank.SECOND) + "개");
        System.out.printf(
            format, Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), lottoResult.getLottoResults().get(Rank.FIRST));
    }
}
