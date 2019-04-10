package util;

import domain.Lotto;

public class PrintUtil {
        public static void printPurchaseAmountInputMessage(){
                System.out.println("구입금액을 입력해 주세요.");
        }

        public static void printPurchaseConfirmMessage(int numberOfLotto){
                System.out.println(numberOfLotto+"개를 구매했습니다.");
        }

        public static void printPurchasedLottoList(Lotto[] lottos){
                for(Lotto lotto : lottos){
                        printPurchasedLotto(lotto);
                }
        }

        public static void printLastWeekWinningNumberInputMessage(){
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        }

        public static void printBonusBallInputMessage(){
                System.out.println("보너스 볼을 입력해 주세요.");
        }

        public static void printWinStatsMessage(){
                System.out.println("\n당첨통계");
                System.out.println("---------");
        }

        private static void printPurchasedLotto(Lotto lotto){
                lotto.printNumbers();
        }
}
