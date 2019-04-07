package com.kwonmc.lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class GameRunner {
    private Scanner sc = new Scanner(System.in);
    private Game game = new Game();

    public void run() {
        inputUserPurchaseAmount();
        printLottoInfo();
        inputLastWeekNumbers();
        inputBonusNo();
        printLottoMatchResult();
        printLottoMoneyResult();
    }

    private void inputUserPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = sc.nextInt();
        game.setPurchaseAmount(purchaseAmount);
    }

    private void printLottoInfo() {
        System.out.println();
        System.out.println(countLotto() + "개를 구매했습니다.");

        createLottoList();
    }

    private void createLottoList() {
        for (int i = 0; i < countLotto(); i++) {
            Lotto tmp = new Lotto(Lotto.lottoMaker());
            game.addMyLottoList(tmp);
        }
    }

    private int countLotto() {
        return game.getPurchaseAmount() / 1000;
    }

    private void inputLastWeekNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        // TODO 구현
        String lastWeek = sc.next();
        Lotto lotto = new Lotto(new ArrayList<>());
        game.setLastWeekNumbers(lotto);
    }

    private void inputBonusNo() {
        System.out.println("보너스 볼을 입력해주세요");
        int bonusNo = sc.nextInt();
        game.setBonusNo(bonusNo);
    }

    private void printLottoMatchResult() {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(Rank.FIFTH.getCountOfMatch() + "개 일치 (" + Rank.FIFTH.getWinningMoney() +"원) - 0개");
        System.out.println(Rank.FOURTH.getCountOfMatch() + "개 일치 (" + Rank.FOURTH.getWinningMoney() +"원) - 0개");
        System.out.println(Rank.THIRD.getCountOfMatch() + "개 일치 (" + Rank.THIRD.getWinningMoney() +"원) - 0개");
        System.out.println(Rank.SECOND.getCountOfMatch() + "개 일치 (" + Rank.SECOND.getWinningMoney() +"원) - 0개");
        System.out.println(Rank.FIRST.getCountOfMatch() + "개 일치 (" + Rank.FIRST.getWinningMoney() +"원) - 0개");
    }

    private void printLottoMoneyResult() {
        System.out.println("총 수익률은 0.000 입니다.");
    }
}
