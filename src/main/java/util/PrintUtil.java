/*
 *@(#)PrintUtil.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package util;

import domain.Rank;
import object.Lotto;

import java.util.List;
import java.util.Map;

/**
 * 로또 게임에서 전반적인 출력에 대한 기능을 하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class PrintUtil {
        public static void printPurchaseAmountInputMessage() {
                System.out.println("구입금액을 입력해 주세요.");
        }

        public static void printPurchaseConfirmMessage(long numberOfLotto) {
                System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");
        }

        public static void printPurchasedLottoList(List<Lotto> lottos) {
                for (Lotto lotto : lottos) {
                        printPurchasedLotto(lotto);
                }
        }

        public static void printLastWeekWinningNumberInputMessage() {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        }

        public static void printBonusBallInputMessage() {
                System.out.println("보너스 볼을 입력해 주세요.");
        }

        public static void printWinStatsMessage() {
                System.out.println("\n당첨통계");
                System.out.println("---------");
        }

        public static void printWinningStats(Map<Rank, Integer> stats) {
                Rank[] ranks = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
                for (int i = 0; i < 3; i++) {
                        System.out.println(ranks[i].getCountOfMatch() + "개 일치 (" + ranks[i].getWinningMoney() + "원)- " + stats.get(ranks[i]) + "개");
                }
                System.out.println(ranks[3].getCountOfMatch() + "개 일치, 보너스 볼 일치(" + ranks[3].getWinningMoney() + "원)- " + stats.get(ranks[3]) + "개");
                System.out.println(ranks[4].getCountOfMatch() + "개 일치 (" + ranks[4].getWinningMoney() + "원)- " + stats.get(ranks[4]) + "개");
        }

        public static void printYiend(double yield) {
                System.out.printf("총 수익률은 %.3f입니다.", yield);
        }

        private static void printPurchasedLotto(Lotto lotto) {
                lotto.printNumbers();
        }
}
