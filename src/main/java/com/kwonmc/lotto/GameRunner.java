package com.kwonmc.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GameRunner {
    private Scanner sc = new Scanner(System.in);
    private Game game = new Game();

    public void run() {
        inputUserPurchaseAmount();
        printLottoInfo();
        inputLastWeekNumberAndBonusNo();
        printLottoMatchResult();
        printLottoMoneyResult();
    }

    private void inputUserPurchaseAmount() {
        purchaseAmountMessagePrinter();
        int purchaseAmount = sc.nextInt();
        game.setPurchaseAmount(purchaseAmount);
    }

    private void purchaseAmountMessagePrinter() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printLottoInfo() {
        System.out.println();
        int lottoCount = countLotto();
        lottoInfoMessagePrinter(lottoCount);
        createLottoList(lottoCount);
        printLottoList();
    }

    private void lottoInfoMessagePrinter(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private void createLottoList(int lottoCount) {
        ArrayList<Lotto> tmpLottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            tmpLottoList.add(Lotto.lottoMaker());
        }
        game.setMyLottoList(tmpLottoList);
    }

    private void printLottoList() {
        for (Lotto lotto : game.getMyLottoList()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    private int countLotto() {
        return game.getPurchaseAmount() / 1000;
    }

    private void inputLastWeekNumberAndBonusNo() {
        lastWeekNumberMessagePrinter();
        String[] lastWeekStr = sc.next().split(",");
        Lotto lotto = stringArrayToLotto(lastWeekStr);

        bonusNoMessagePrinter();
        int bonusNo = sc.nextInt();

        game.setWinningLotto(new WinningLotto(lotto, bonusNo));
    }

    private Lotto stringArrayToLotto(String[] strArray) {
        int[] intArray = Arrays.stream(strArray)
                .mapToInt(Integer::valueOf)
                .toArray();
        ArrayList<Integer> lottoList = arrayToList(intArray);
        return new Lotto(lottoList);
    }

    private void lastWeekNumberMessagePrinter() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    private void bonusNoMessagePrinter() {
        System.out.println("보너스 볼을 입력해주세요");
    }

    private ArrayList<Integer> arrayToList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    private void printLottoMatchResult() {
        lottoMatchResultMessagePrinter();
        RankList rankList = getRankList(game.getWinningLotto());

        for (int i = rankList.size() - 2; i >= 0; i--) {
            Rank tmpRank = rankList.getRankByIndex(i);
            int tmpCounts = rankList.getCountsByIndex(i);
            System.out.println(tmpRank.getCountOfMatch() + "개 일치(" + tmpRank.getWinningMoney() + "원)- " + tmpCounts +"개");
        }
    }

    private RankList getRankList(WinningLotto winningLotto) {
        RankList rankList = new RankList();

        for (Lotto lotto : this.game.getMyLottoList()) {
            rankList.add(winningLotto.match(lotto));
        }

        return rankList;
    }

    private void lottoMatchResultMessagePrinter() {
        System.out.println("당첨통계");
        System.out.println("---------");
    }

    private void printLottoMoneyResult(/*int purchaseAmount, int winningAmount*/) {
        System.out.println("총 수익률은 0.000 입니다.");
    }
}
