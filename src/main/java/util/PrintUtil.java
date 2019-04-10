package util;

import domain.Rank;
import object.Lotto;

import java.util.List;
import java.util.Map;

public class PrintUtil {
        public static void printPurchaseAmountInputMessage() {
                System.out.println("구입금액을 입력해 주세요.");
        }

        public static void printPurchaseConfirmMessage(int numberOfLotto) {
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
                for (Rank rank : Rank.values()) {
                        System.out.println(rank.getCountOfMatch() + "개 일치 ("
                                + rank.getWinningMoney() + "원)- " + stats.get(rank));
                }
        }

        public static void printYiend(double yield){
               System.out.printf("총 수익률은 %.3lf입니다.",yield);
        }

        private static void printPurchasedLotto(Lotto lotto) {
                lotto.printNumbers();
        }
}
