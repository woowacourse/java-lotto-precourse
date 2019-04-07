package com.kwonmc.lotto;

import java.util.Scanner;

public class GameRunner {
    private Scanner sc = new Scanner(System.in);
    private Game game = new Game();

    public void run() {
        inputUserPurchaseAmount();
        printLottoList();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastWeek = sc.next();

        System.out.println("보너스 볼을 입력해주세요");
        int bonusNo = sc.nextInt();

        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(Rank.FIFTH.getCountOfMatch() + "개 일치 (" + Rank.FIFTH.getWinningMoney() +") - 0개");
        System.out.println(Rank.FOURTH.getCountOfMatch() + "개 일치 (" + Rank.FOURTH.getWinningMoney() +") - 0개");
        System.out.println(Rank.THIRD.getCountOfMatch() + "개 일치 (" + Rank.THIRD.getWinningMoney() +") - 0개");
        System.out.println(Rank.SECOND.getCountOfMatch() + "개 일치 (" + Rank.SECOND.getWinningMoney() +") - 0개");
        System.out.println(Rank.FIRST.getCountOfMatch() + "개 일치 (" + Rank.FIRST.getWinningMoney() +") - 0개");

        System.out.println("총 수익률은 0.000 입니다.");
    }

    private void inputUserPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = sc.nextInt();
        game.setPurchaseAmount(purchaseAmount);
    }

    private void printLottoList() {
        System.out.println();
        System.out.println(game.getPurchaseAmount() / 1000 + "개를 구매했습니다.");
    }
}
